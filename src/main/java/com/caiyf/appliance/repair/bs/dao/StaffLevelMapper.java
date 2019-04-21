package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.StaffLevelPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc 员工级别dao
 * @date 2019/04/21
 * @author caiyf
 */
@Mapper
@Repository
public interface StaffLevelMapper {

    /**
     * 获取所有po
     * @return
     */
    List<StaffLevelPo> getAllPo();

}
