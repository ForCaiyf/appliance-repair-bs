package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.StaffInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @desc 员工信息dao
 * @date 2019/04/21
 * @author caiyf
 */
@Mapper
@Repository
public interface StaffInfoMapper {

    StaffInfoPo getPoById(@Param("id") Long id);

    void insertPo(@Param("po") StaffInfoPo staffInfoPo);

}
