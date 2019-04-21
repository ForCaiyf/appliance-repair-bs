package com.caiyf.appliance.repair.bs.model.po;

import lombok.Data;

/**
 * @desc 员工po
 * @date 2019/04/20
 * @author caiyf
 */
@Data
public class StaffPo {

    private Long id;
    private Integer num;
    private String name;
    private String passwordEncrypt;
    private Integer typeId;
    private Integer levelId;
    private Long infoId;
    private Long agentId;
    private Integer infoFilled;

}
