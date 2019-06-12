package com.caiyf.appliance.repair.bs.service;

import com.caiyf.appliance.repair.bs.config.WeChatConfig;
import com.caiyf.appliance.repair.bs.dao.*;
import com.caiyf.appliance.repair.bs.exception.BusinessException;
import com.caiyf.appliance.repair.bs.model.constant.PatternConstant;
import com.caiyf.appliance.repair.bs.model.po.*;
import com.caiyf.appliance.repair.bs.model.request.JswxRequest;
import com.caiyf.appliance.repair.bs.model.request.PjRequest;
import com.caiyf.appliance.repair.bs.model.request.WxyyRequest;
import com.caiyf.appliance.repair.bs.model.response.OrderDetailResponse;
import com.caiyf.appliance.repair.bs.model.response.WeChatLoginResponse;
import com.caiyf.appliance.repair.bs.model.result.CodeEnum;
import com.caiyf.appliance.repair.bs.util.HttpClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @desc 微信相关service
 * @date 2019/05/10
 * @author caiyf
 */
@Slf4j
@Service
public class WeChatService {

    @Autowired
    private WeChatConfig weChatConfig;
    @Autowired
    private RepairInfoMapper repairInfoMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private RepairShopMapper repairShopMapper;
    @Autowired
    private OrderFeedbackMapper orderFeedbackMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 获得登录所需值
     * @return
     */
    public WeChatLoginResponse getOpenId(String code) {
        String openId = null;
        String sessionKey = null;
        WeChatLoginResponse weChatLoginResponse = new WeChatLoginResponse();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(weChatConfig.getSessionHost())
                .append("?")
                .append("appid=")
                .append(weChatConfig.getAppId())
                .append("&secret=")
                .append(weChatConfig.getSecret())
                .append("&js_code=")
                .append(code)
                .append("&grant_type=")
                .append(weChatConfig.getGrantType());
        String uri = stringBuilder.toString();
        JSONObject response = HttpClient.doGet(uri);
        try {
            openId = response.get("openid") + "";
            sessionKey = response.get("session_key") + "";
        } catch (Exception e) {
            log.error("wechat log error", e);
            throw new BusinessException(CodeEnum.LOGIN_ERROR, e);
        }
        weChatLoginResponse.setOpenId(openId);
        weChatLoginResponse.setSessionKey(sessionKey);
        return weChatLoginResponse;
    }

    /**
     * '维修预约'处理
     * @param request
     * @param openId
     */
    @Transactional
    public void wxyy(WxyyRequest request, String openId) {
        /** 转换对象（request->po） */
        RepairInfoPo repairInfoPo = new RepairInfoPo();
        repairInfoPo.setName(request.getName());
        repairInfoPo.setPhone(request.getPhone());
        repairInfoPo.setAddress(request.getAddress());
        // 预约时间String转换成Date
        SimpleDateFormat format = new SimpleDateFormat(PatternConstant.DATE_CONSTANT);
        try {
            Date appointmentDate = format.parse(request.getTime());
            repairInfoPo.setAppointmentDate(appointmentDate);
        } catch (ParseException e) {
            log.error("[appointment-date format error]", e);
            throw new BusinessException(CodeEnum.DATE_FOMMATE_ERROR);
        }
        repairInfoPo.setDesc(request.getDesc());
        /** 存储维修单 */
        repairInfoMapper.insertPo(repairInfoPo);
        Long repairInfoId = repairInfoPo.getId();
        /** 创建订单并存储 */
        OrderPo orderPo = new OrderPo();
        orderPo.setOpenId(openId);
        orderPo.setRepairInfoId(repairInfoId);
        orderPo.setType(request.getType());
        orderPo.setStatus(1);
        orderPo.setStatusChangedAt(new Date(System.currentTimeMillis()));
        orderMapper.insertPo(orderPo);
    }

    /**
     * ‘进度查看’处理
     * @param openId
     * @return
     */
    public OrderPo jdck(String openId) {
        OrderPo orderPo = orderMapper.getPoByOpenId(openId);
        if (null == orderPo) {
            return null;
        }
        return orderPo;
    }

    /**
     * '极速维修'处理
     * @param request
     * @param openId
     */
    @Transactional
    public void jswx(JswxRequest request, String openId) {
        RepairInfoPo repairInfoPo = new RepairInfoPo();
        repairInfoPo.setName(request.getName());
        repairInfoPo.setPhone(request.getPhone());
        repairInfoPo.setAddress(request.getAddress());
        repairInfoPo.setDesc(request.getDesc());
        /** 存储维修单 */
        repairInfoMapper.insertPo(repairInfoPo);
        Long repairInfoId = repairInfoPo.getId();
        /** 分配维修员 */
        // 最后订单时间应小于当前时间一小时的维修员才能接单
        Date date = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        Integer repairerNum = -1;
        List<StaffPo> allRepairPo = staffMapper.getAllRepairPo();
        // 遍历每一个维修人员
        for (StaffPo staff : allRepairPo) {
            Date lastOrderTime = orderMapper.getLastOrderTime(staff.getNum());
            if (lastOrderTime == null) {
                repairerNum = staff.getNum();
                break;
            }
            if (lastOrderTime.before(date)) {
                repairerNum = staff.getNum();
                break;
            }
        }
        if (repairerNum == -1) {
            throw new BusinessException(CodeEnum.NO_SUITABLE_REPAIRER_ERROR);
        }
        /** 创建订单并存储 */
        OrderPo orderPo = new OrderPo();
        orderPo.setOpenId(openId);
        orderPo.setRepairInfoId(repairInfoId);
        orderPo.setType(request.getType());
        orderPo.setStatus(1);
        orderPo.setRepairNum(repairerNum);
        orderPo.setStatusChangedAt(new Date(System.currentTimeMillis()));
        orderMapper.insertPo(orderPo);
    }

    /**
     * ‘家电推荐’处理
     * @return
     */
    public List<GoodsPo> jdtj() {
        return goodsMapper.getAllPo();
    }

    /**
     * 获取订单列表
     * @param openId
     * @return
     */
    public List<OrderPo> getOrderList(String openId) {
        // 沉睡一秒来显示前端效果
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            log.error("", e);
        }
        return orderMapper.getListByOpenId(openId);
    }

    /**
     * ‘送店维修’处理
     * @return
     */
    public List<RepairShopPo> sdwx() {
        return repairShopMapper.getAllPo();
    }

    /**
     * 订单详情
     * @param id
     * @return
     */
    public OrderDetailResponse getOrderDetail(Long id) {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setId(id);
        OrderPo orderPo = orderMapper.getPoById(id);
        if (orderPo.getStaffNum() == 0) {
            orderDetailResponse.setStaff("-");
        } else {
            StaffPo staff = staffMapper.getPoByNum(orderPo.getStaffNum());
            orderDetailResponse.setStaff(staff.getName());
        }
        if (orderPo.getRepairNum() == 0) {
            orderDetailResponse.setRepair("-");
        } else {
            StaffPo staff = staffMapper.getPoByNum(orderPo.getRepairNum());
            orderDetailResponse.setRepair(staff.getName());
        }
        if (orderPo.getStatus() == 1) {
            orderDetailResponse.setStatus("提交订单");
        } else if (orderPo.getStatus() == 2) {
            orderDetailResponse.setStatus("分配维修员");
        } else if (orderPo.getStatus() == 3) {
            orderDetailResponse.setStatus("维修中");
        } else if (orderPo.getStatus() == 4) {
            orderDetailResponse.setStatus("待评价");
        } else {
            orderDetailResponse.setStatus("已完成");
        }
        if (orderPo.getType() == 1) {
            orderDetailResponse.setType("维修预约");
        } else if(orderPo.getType() == 2) {
            orderDetailResponse.setType("极速维修");
        } else if(orderPo.getType() == 3) {
            orderDetailResponse.setType("到店维修");
        } else if(orderPo.getType() == 4) {
            orderDetailResponse.setType("家电安装");
        } else {
            orderDetailResponse.setType("清洁保养");
        }
        RepairInfoPo repairInfoPo = repairInfoMapper.getPoById(orderPo.getRepairInfoId());
        orderDetailResponse.setName(repairInfoPo.getName());
        orderDetailResponse.setPhone(repairInfoPo.getPhone());
        orderDetailResponse.setAddress(repairInfoPo.getAddress());
        SimpleDateFormat format = new SimpleDateFormat(PatternConstant.DATE_CONSTANT);
        orderDetailResponse.setAppointmentDate(format.format(repairInfoPo.getAppointmentDate()));
        if (orderPo.getStatus() >= 4) {
            OrderFeedback orderFeedback = orderFeedbackMapper.getPoById(orderPo.getFeedbackId());
            orderDetailResponse.setCost(orderFeedback.getCost());
            orderDetailResponse.setPay(orderFeedback.getPay());
            orderDetailResponse.setEvaluate(orderFeedback.getEvaluate());
            orderDetailResponse.setSummary(orderFeedback.getSummary());
        } else {
            orderDetailResponse.setCost(0.0f);
            orderDetailResponse.setPay(0.0f);
            orderDetailResponse.setEvaluate("-");
            orderDetailResponse.setSummary("-");
        }
        return orderDetailResponse;
    }

    /**
     * 订单评价
     * @param request
     * @param id
     */
    public void orderPj(PjRequest request, Long id) {
        String pj = request.getPj();
        OrderPo orderPo = orderMapper.getPoById(id);
        orderFeedbackMapper.setPj(orderPo.getFeedbackId() , pj);
    }

}
