package com.caiyf.appliance.repair.bs.model.po;

import lombok.Data;

import java.util.Date;

/**
 * @desc 订单po
 * @date 2019/04/19
 * @author caiyf
 */
@Data
public class OrderPo {

    private Long id;
    private String openId;
    private Long repairInfoId;
    private Long feedbackId;
    private Integer staffNum;
    private Integer repairNum;
    private Integer status;
    private Integer type;
    private Date statusChangedAt;

}
