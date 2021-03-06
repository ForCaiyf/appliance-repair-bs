package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.MarriagePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc 婚姻状况dao
 * @date 2019/04/19
 * @author caiyf
 */
@Mapper
@Repository
public interface MarriageMapper {

    /**
     * 获得所有po
     * @return
     */
    List<MarriagePo> getAllPo();

    /**
     * 通过id获得marriage
     * @param id
     * @return
     */
    String getMarriageById(@Param("id") Integer id);

}
