package com.caiyf.appliance.repair.bs.service;

import com.caiyf.appliance.repair.bs.dao.StaffInfoMapper;
import com.caiyf.appliance.repair.bs.dao.StaffLevelMapper;
import com.caiyf.appliance.repair.bs.dao.StaffMapper;
import com.caiyf.appliance.repair.bs.dao.StaffTypeMapper;
import com.caiyf.appliance.repair.bs.model.po.StaffLevelPo;
import com.caiyf.appliance.repair.bs.model.po.StaffTypePo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @desc 员工service
 * @date 2019/04/21
 * @author caiyf
 */
public class StaffService {

    @Autowired
    private StaffTypeMapper staffTypeMapper;
    @Autowired
    private StaffLevelMapper staffLevelMapper;
    @Autowired
    private StaffInfoMapper staffInfoMapper;
    @Autowired
    private StaffMapper staffMapper;

    /**
     * 获取员工类型列表
     * @return
     */
    public List<StaffTypePo> getStaffTypeList() {
        return staffTypeMapper.getAllPo();
    }

    /**
     * 获取员工级别列表
     * @return
     */
    public List<StaffLevelPo> getStaffLevelList() {
        return staffLevelMapper.getAllPo();
    }

}
