package com.caiyf.appliance.repair.bs.model.request;

import lombok.Data;

/**
 * @desc 极速预约request
 * @date 2019/05/25
 * @author caiyf
 */
@Data
public class JswxRequest {

    private String name;
    private String phone;
    private String address;
    private String desc;
    private Integer type;

}
