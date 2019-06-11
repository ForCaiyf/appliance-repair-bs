package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.RepairShopPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RepairShopMapper {

    List<RepairShopPo> getAllPo();

}
