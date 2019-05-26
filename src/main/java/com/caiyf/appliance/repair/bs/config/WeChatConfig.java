package com.caiyf.appliance.repair.bs.config;

import com.caiyf.appliance.repair.bs.model.constant.ConfigConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @desc 微信相关配置
 * @date 2019/04/13
 * @author caiyf
 */
@Data
@Component
@ConfigurationProperties(prefix = ConfigConstant.WX_PREFIX)
public class WeChatConfig {

    private String sessionHost;
    private String appId;
    private String secret;
    private String grantType;

}
