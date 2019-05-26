package com.caiyf.appliance.repair.bs.service;

import com.caiyf.appliance.repair.bs.config.WeChatConfig;
import com.caiyf.appliance.repair.bs.exception.BusinessException;
import com.caiyf.appliance.repair.bs.model.request.WxyyRequest;
import com.caiyf.appliance.repair.bs.model.response.WeChatLoginResponse;
import com.caiyf.appliance.repair.bs.model.result.CodeEnum;
import com.caiyf.appliance.repair.bs.util.HttpClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @desc 微信相关service
 * @date 2019/05/10
 * @author caiyf
 */
@Slf4j
@Service
public class WeChatService {

    @Autowired
    private WeChatConfig weChatConfig;

    /**
     * 获得登录所需值
     * @return
     */
    public WeChatLoginResponse getOpenId(String code) {
        String openId = null;
        String sessionKey = null;
        WeChatLoginResponse weChatLoginResponse = new WeChatLoginResponse();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(weChatConfig.getSessionHost())
                .append("?")
                .append("appid=")
                .append(weChatConfig.getAppId())
                .append("&secret=")
                .append(weChatConfig.getSecret())
                .append("&js_code=")
                .append(code)
                .append("&grant_type=")
                .append(weChatConfig.getGrantType());
        String uri = stringBuilder.toString();
        JSONObject response = HttpClient.doGet(uri);
        try {
            openId = response.get("openid") + "";
            sessionKey = response.get("session_key") + "";
        } catch (Exception e) {
            log.error("登录失败", e);
            throw new BusinessException(CodeEnum.LOGIN_ERROR, e);
        }
        weChatLoginResponse.setOpenId(openId);
        weChatLoginResponse.setSessionKey(sessionKey);
        return weChatLoginResponse;
    }

    /**
     * 维修预约处理
     * @param request
     * @param openId
     */
    public void wxyy(WxyyRequest request, String openId) {
        System.out.println(openId);
    }

}
