package com.caiyf.appliance.repair.bs.model.bo;

import lombok.Data;

/**
 * @desc 员工bo
 * @date 2019/05/05
 * @author caiyf
 */
@Data
public class StaffBo {

    private Long id;
    private Integer num;
    private String name;
    private String type;
    private String level;
    private Long infoId;

}
