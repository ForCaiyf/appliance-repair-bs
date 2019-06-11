package com.caiyf.appliance.repair.bs.model.po;

import lombok.Data;

/**
 * @desc 员工信息po
 * @date 2019/04/20
 * @author caiyf
 */
@Data
public class StaffInfoPo {

    private Long id;
    private String name;
    private Integer age;
    private Integer sexId;
    private String idCard;
    private String phone;
    private String email;
    private String school;
    private Integer educationId;
    private Integer nationId;
    private Integer marriageId;
    private String experience;
    private String imageUrl;
    private String address;
    private String familyContact;
    private String familyPhone;
    private String emergencyContact;
    private String emergencyPhone;

}
