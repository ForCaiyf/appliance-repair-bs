package com.caiyf.appliance.repair.bs.model.po;

import lombok.Data;

/**
 * @desc 派工po
 * @date 2019/04/26
 * @author caiyf
 */
@Data
public class OrderFeedback {

    private Long id;
    private Float cost;
    private Float pay;
    private String evaluate;
    private String appraised;
    private String summary;

}
