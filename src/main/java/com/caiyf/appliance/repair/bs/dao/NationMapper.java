package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.NationPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc 民族dao
 * @date 2019/04/19
 * @author caiyf
 */
@Mapper
@Repository
public interface NationMapper {

    /**
     * 获取所有po
     * @return
     */
    List<NationPo> getAllPo();

    /**
     * 通过id获得nation
     * @param id
     * @return
     */
    String getNationById(@Param("id") Integer id);

}
