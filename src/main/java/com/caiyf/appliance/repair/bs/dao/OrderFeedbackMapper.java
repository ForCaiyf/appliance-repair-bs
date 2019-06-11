package com.caiyf.appliance.repair.bs.dao;

import com.caiyf.appliance.repair.bs.model.po.OrderFeedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderFeedbackMapper {

    /**
     * 添加po
     * @param po
     * @return
     */
    Integer insertPo(@Param("po") OrderFeedback po);

    OrderFeedback getPoById(@Param("id") Long id);

}
