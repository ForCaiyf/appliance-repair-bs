package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.OrderPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @desc 订单dao
 * @date 2019/04/26
 * @author caiyf
 */
@Mapper
@Repository
public interface OrderMapper {

    /**
     * 添加po
     * @param po
     */
    void insertPo(@Param("po") OrderPo po);

    /**
     * 查询维修中po
     * @param openId
     * @return
     */
    OrderPo getPoByOpenId(@Param("openId") String openId);

    /**
     * 根据id获取po
     * @param id
     * @return
     */
    OrderPo getPoById(@Param("id") Long id);

    /**
     * 订单列表查询
     * @param openId
     * @return
     */
    List<OrderPo> getListByOpenId(@Param("openId") String openId);

    Date getLastOrderTime(@Param("staffNum") Integer staffNum);

}
