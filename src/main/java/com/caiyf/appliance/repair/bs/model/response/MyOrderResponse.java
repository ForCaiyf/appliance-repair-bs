package com.caiyf.appliance.repair.bs.model.response;

import lombok.Data;

@Data
public class MyOrderResponse {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private String time;
    private String type;
    private String desc;
    private String staff = "-";
    private String status;

}
