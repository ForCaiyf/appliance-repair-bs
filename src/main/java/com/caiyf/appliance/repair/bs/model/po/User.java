package com.caiyf.appliance.repair.bs.model.po;

import lombok.Data;

import java.util.Date;

/**
 * @desc 微信用户信息po
 * @date 2019/05/10
 * @author caiyf
 */
@Data
public class User {

    private Long id;
    private String openId;
    private String skey;
    private Date createdAt;
    private Date lastVisitTime;
    private String sessionKey;
    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    private String gender;
    private String nickName;
    private Integer isDeleted;

}
