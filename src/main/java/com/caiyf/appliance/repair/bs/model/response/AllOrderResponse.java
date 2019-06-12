package com.caiyf.appliance.repair.bs.model.response;

import lombok.Data;

@Data
public class AllOrderResponse {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private String time;
    private String type;
    private String desc;
    private String staff = "-";
    private String repair = "-";
    private String status;
    private String pj = "-";
    private String summary = "-";
    private double cost = -1.0;
    private double pay = -1.0;

}
