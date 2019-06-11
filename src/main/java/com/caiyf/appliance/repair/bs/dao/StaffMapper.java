package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.StaffPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc 员工dao
 * @date 2019/04/21
 * @author caiyf
 */
@Mapper
@Repository
public interface StaffMapper {

    /**
     * 获取所有po
     * @return
     */
    List<StaffPo> getAllPo();

    /**
     * 获取所有维修员po
     * @return
     */
    List<StaffPo> getAllRepairPo();

    /**
     * 通过num获取用户
     * @param num
     * @return
     */
    StaffPo getPoByNum(@Param("num") Integer num);

}
