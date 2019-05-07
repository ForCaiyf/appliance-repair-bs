package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.EducationPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc 学历dao
 * @date 2019/04/19
 * @author caiyf
 */
@Mapper
@Repository
public interface EducationMapper {

    /**
     * 获得所有po
     * @return
     */
    List<EducationPo> getAllPo();

    /**
     * 通过id获得education
     * @param id
     * @return
     */
    String getEducationById(@Param("id") Integer id);

}
