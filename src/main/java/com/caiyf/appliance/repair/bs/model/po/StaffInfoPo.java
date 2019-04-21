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
    private String idCardEncrypt;
    private String phoneEncrypt;
    private String email;
    private String school;
    private Integer educationId;
    private Integer nationId;
    private Integer marriageId;
    private String experience;
    private String imageUrl;
    private String address;
    private String familyContact;
    private String familyPhoneEncrypt;
    private String emergencyContact;
    private String emergencyPhoneEncrypt;

}
