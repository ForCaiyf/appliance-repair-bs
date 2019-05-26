package com.caiyf.appliance.repair.bs.model.response;

import lombok.Data;

/**
 * @desc 微信登录返回值
 * @date 2019/05/10
 * @author caiyf
 */
@Data
public class WeChatLoginResponse {

    private String openId;
    private String sessionKey;

}
