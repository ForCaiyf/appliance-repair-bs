package com.caiyf.appliance.repair.bs.model.bo;

import lombok.Data;

/**
 * @desc 员工信息bo
 * @date 2019/05/05
 * @author caiyf
 */
@Data
public class StaffInfoBo {

    private Long id;
    private String name;
    private Integer age;
    private String sex;
    private String idCardEncrypt;
    private String phoneEncrypt;
    private String email;
    private String school;
    private String education;
    private String nation;
    private String marriage;
    private String experience;
    private String imageUrl;
    private String address;
    private String familyContact;
    private String familyPhoneEncrypt;
    private String emergencyContact;
    private String emergencyPhoneEncrypt;

}
