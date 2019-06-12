package com.caiyf.appliance.repair.bs.service;

import com.caiyf.appliance.repair.bs.dao.OrderFeedbackMapper;
import com.caiyf.appliance.repair.bs.dao.OrderMapper;
import com.caiyf.appliance.repair.bs.dao.RepairInfoMapper;
import com.caiyf.appliance.repair.bs.dao.StaffMapper;
import com.caiyf.appliance.repair.bs.model.constant.PatternConstant;
import com.caiyf.appliance.repair.bs.model.po.OrderFeedback;
import com.caiyf.appliance.repair.bs.model.po.OrderPo;
import com.caiyf.appliance.repair.bs.model.po.RepairInfoPo;
import com.caiyf.appliance.repair.bs.model.po.StaffPo;
import com.caiyf.appliance.repair.bs.model.request.FpOrderRequest;
import com.caiyf.appliance.repair.bs.model.response.AllOrderResponse;
import com.caiyf.appliance.repair.bs.model.response.FdcResponse;
import com.caiyf.appliance.repair.bs.model.response.MyOrderResponse;
import com.caiyf.appliance.repair.bs.model.response.SummaryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RepairInfoMapper repairInfoMapper;
    @Autowired
    private OrderFeedbackMapper orderFeedbackMapper;
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 所有订单
     * @return
     */
    public List<AllOrderResponse> getAllOrder() {
        List<AllOrderResponse> response = new ArrayList<>();
        List<OrderPo> list = orderMapper.getAll();
        for (OrderPo po: list) {
            AllOrderResponse a = new AllOrderResponse();
            a.setId(po.getId());
            if (po.getStaffNum() != 0) {
                StaffPo staff = staffMapper.getPoByNum(po.getStaffNum());
                a.setStaff(staff.getName());
            }
            if (po.getRepairNum() != 0) {
                StaffPo staff = staffMapper.getPoByNum(po.getRepairNum());
                a.setRepair(staff.getName());
            }
            if (po.getType() == 1) {
                a.setType("维修预约");
            } else if(po.getType() == 2) {
                a.setType("极速维修");
            } else if(po.getType() == 3) {
                a.setType("到店维修");
            } else if(po.getType() == 4) {
                a.setType("家电安装");
            } else {
                a.setType("清洁保养");
            }
            RepairInfoPo repairInfoPo = repairInfoMapper.getPoById(po.getRepairInfoId());
            a.setAddress(repairInfoPo.getAddress());
            a.setDesc(repairInfoPo.getDesc());
            a.setName(repairInfoPo.getName());
            a.setPhone(repairInfoPo.getPhone());
            SimpleDateFormat format = new SimpleDateFormat(PatternConstant.DATE_CONSTANT);
            a.setTime(format.format(repairInfoPo.getAppointmentDate()));
            response.add(a);
            if (po.getStatus() >= 4) {
                OrderFeedback orderFeedback = orderFeedbackMapper.getPoById(po.getFeedbackId());
                a.setCost(orderFeedback.getCost());
                a.setPay(orderFeedback.getPay());
                a.setPj(orderFeedback.getEvaluate());
                a.setSummary(orderFeedback.getSummary());
            }
            response.add(a);
        }
        return response;
    }

    /**
     * 我的订单
     * @param num
     * @return
     */
    public List<MyOrderResponse> getMyOrder(Integer num) {
        List<MyOrderResponse> response = new ArrayList<>();
        List<OrderPo> list = orderMapper.getMyOrderList(num);
        for (OrderPo po: list) {
            MyOrderResponse m = new MyOrderResponse();
            m.setId(po.getId());
            if (po.getStaffNum() != 0) {
                StaffPo staff = staffMapper.getPoByNum(po.getStaffNum());
                m.setStaff(staff.getName());
                if (po.getType() == 1) {
                    m.setType("维修预约");
                } else if(po.getType() == 2) {
                    m.setType("极速维修");
                } else if(po.getType() == 3) {
                    m.setType("到店维修");
                } else if(po.getType() == 4) {
                    m.setType("家电安装");
                } else {
                    m.setType("清洁保养");
                }
                RepairInfoPo repairInfoPo = repairInfoMapper.getPoById(po.getRepairInfoId());
                m.setAddress(repairInfoPo.getAddress());
                m.setDesc(repairInfoPo.getDesc());
                m.setName(repairInfoPo.getName());
                m.setPhone(repairInfoPo.getPhone());
                SimpleDateFormat format = new SimpleDateFormat(PatternConstant.DATE_CONSTANT);
                m.setTime(format.format(repairInfoPo.getAppointmentDate()));
                response.add(m);
            }
        }
        return response;
    }

    /**
     * 获取分单池数据
     * @return
     */
    public List<FdcResponse> getFdcList() {
        List<FdcResponse> response = new ArrayList();
        List<OrderPo> list = orderMapper.getFdcOrderList();
        for (OrderPo po: list) {
            FdcResponse fdcResponse = new FdcResponse();
            fdcResponse.setId(po.getId());
            if (po.getType() == 1) {
                fdcResponse.setType("维修预约");
            } else if(po.getType() == 2) {
                fdcResponse.setType("极速维修");
            } else if(po.getType() == 3) {
                fdcResponse.setType("到店维修");
            } else if(po.getType() == 4) {
                fdcResponse.setType("家电安装");
            } else {
                fdcResponse.setType("清洁保养");
            }
            RepairInfoPo repairInfoPo = repairInfoMapper.getPoById(po.getRepairInfoId());
            fdcResponse.setAddress(repairInfoPo.getAddress());
            fdcResponse.setDesc(repairInfoPo.getDesc());
            fdcResponse.setName(repairInfoPo.getName());
            fdcResponse.setPhone(repairInfoPo.getPhone());
            SimpleDateFormat format = new SimpleDateFormat(PatternConstant.DATE_CONSTANT);
            fdcResponse.setTime(format.format(repairInfoPo.getAppointmentDate()));
            response.add(fdcResponse);
        }
        return response;
    }

    /**
     * 订单分配
     * @param num
     * @param request
     */
    public void fpOrder(Integer num, FpOrderRequest request) {
        orderMapper.updateFp(num, request.getRepairId(), request.getId());
    }

    /**
     * 开始订单
     * @param id
     */
    public void startOrder(Long id) {
        orderMapper.updateStart(id);
    }

    /**
     * 订单总结
     * @param request
     */
    @Transactional
    public void summary(OrderFeedback request) {
        orderFeedbackMapper.insertPo(request);
        Long feedbackId = request.getId();
        orderMapper.updateSummary(request.getId(), feedbackId);
    }


}
