package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.RepairInfoPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @desc 维修信息dao
 * @date 2019/04/19
 * @author caiyf
 */
@Mapper
@Repository
public interface RepairInfoMapper {

    /**
     * 添加po
     * @param repairInfoPo
     * @return
     */
    Integer insertPo(@Param("po")RepairInfoPo repairInfoPo);

    RepairInfoPo getPoById(@Param("id") Long id);

}
