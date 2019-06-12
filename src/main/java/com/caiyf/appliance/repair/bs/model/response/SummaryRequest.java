package com.caiyf.appliance.repair.bs.model.response;

import lombok.Data;

@Data
public class SummaryRequest {

    private double cost;
    private double pay;
    private String summary;

}
