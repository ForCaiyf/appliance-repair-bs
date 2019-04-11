package com.caiyf.appliance.repair.bs.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.caiyf.appliance.repair.bs.model.constant.ConfigurationContant;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @desc druid连接池
 * @date 2019/04/11
 * @author caiyf
 */
@Slf4j
@Setter
@Configuration
@ConfigurationProperties(prefix = ConfigurationContant.DB_PREFIX)
public class DruidConfiguration {

    private String url;
    private String dataUsername;
    private String dataPassword;
    private String driverClassName;

    @Bean
    public DataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(dataUsername);
        dataSource.setPassword(dataPassword);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

}
