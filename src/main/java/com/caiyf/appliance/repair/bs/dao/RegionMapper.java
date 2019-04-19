package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.RegionPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @desc 地区dao
 * @date 2019/04/19
 * @author caiyf
 */
@Mapper
@Repository
public interface RegionMapper {

    /**
     * 根据id获取po
     * @param id
     * @return
     */
    RegionPo getPoById(@Param("id") Integer id);

    /**
     * 根据type获取po列表
     * @param type
     * @return
     */
    List<RegionPo> getPoListByType(@Param("type") Integer type);

    /**
     * 根据parentId获取po列表
     * @param parentId
     * @return
     */
    List<RegionPo> getPoListByParentId(@Param("parentId") Integer parentId);

}
