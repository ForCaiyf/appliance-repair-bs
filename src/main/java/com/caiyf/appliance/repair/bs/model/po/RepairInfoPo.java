package com.caiyf.appliance.repair.bs.model.po;

import lombok.Data;

import java.util.Date;

/**
 * @desc 维修单po
 * @date 2019/04/26
 * @author caiyf
 */
@Data
public class RepairInfoPo {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private String desc;
    private Date appointmentDate;
    private Integer isDistribution;

}
