package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.StaffTypePo;

import java.util.List;

/**
 * @desc 员工类型dao
 * @date 2019/04/21
 * @author caiyf
 */
public interface StaffTypeMapper {

    /**
     * 获取所有po
     * @return
     */
    List<StaffTypePo> getAllPo();

}
