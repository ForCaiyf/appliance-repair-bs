package com.caiyf.appliance.repair.bs.model.po;

import lombok.Data;

/**
 * @desc 地区po
 * @date 2019/04/19
 * @author caiyf
 */
@Data
public class RegionPo {

    private Integer id;
    private Integer parentId;
    private String name;
    private Integer type;

}
