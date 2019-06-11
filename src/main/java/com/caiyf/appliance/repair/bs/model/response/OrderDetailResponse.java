package com.caiyf.appliance.repair.bs.model.response;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDetailResponse {

    private Long id;
    private String name;
    private String phone;
    private String address;
    private String desc;
    private String appointmentDate;
    private String openId;
    private String staff;
    private String repair;
    private String status;
    private String type;
    private Float cost;
    private Float pay;
    private String evaluate;
    private String appraised;
    private String summary;

}
