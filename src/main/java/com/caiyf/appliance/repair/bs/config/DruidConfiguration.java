package com.caiyf.appliance.repair.bs.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.caiyf.appliance.repair.bs.model.constant.ConfigurationContant;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @desc druid配置
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
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    private Long maxWait;
    private Long timeBetweenEvictionRunsMillis;
    private Long minEvictableIdleTimeMillis;
    private String filters;
    private String connectionProperties;
    private String druidAdmin;
    private String druidPassword;

    /**
     * 连接池配置
     * @return
     */
    @Bean
    public DataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(dataUsername);
        dataSource.setPassword(dataPassword);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        try {
            dataSource.setFilters(filters);
        } catch (SQLException e) {
            log.error("", e);
        }
        dataSource.setConnectionProperties(connectionProperties);
        return dataSource;
    }

    /**
     * 关联监控数据filter配置
     * @return
     */
    public FilterRegistrationBean generateDruidFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    /**
     * 监控页面配置
     * @return
     */
    @Bean
    public ServletRegistrationBean generateDruidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", druidAdmin);
        servletRegistrationBean.addInitParameter("loginPassword", druidPassword);
        // 禁用控制台“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

}
