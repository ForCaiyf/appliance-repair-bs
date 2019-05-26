package com.caiyf.appliance.repair.bs.model.request;

import lombok.Data;

/**
 * @desc 维修预约request
 * @date 2019/05/25
 * @author caiyf
 */
@Data
public class WxyyRequest {

    private String name;
    private String phone;
    private String address;
    private String time;
    private String desc;

}
