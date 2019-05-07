package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.SexPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc 性别dao
 * @date 2019/04/19
 * @author caiyf
 */
@Mapper
@Repository
public interface SexMapper {

    /**
     * 获取所有po
     * @return
     */
    List<SexPo> getAllPo();

    /**
     * 通过id获取sex
     * @param id
     * @return
     */
    String getSexById(@Param("id") Integer id);

}
