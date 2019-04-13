package com.caiyf.appliance.repair.bs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @desc swagger配置
 * @date 2019/04/13
 * @author caiyf
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private static final String CONTROLLER_PACKAGE = "com.caiyf.appliance.repair.bs.controller";

    /**
     * 支持swagger插件
     * @return
     */
    @Bean
    public Docket integrateSwaggerPlugin() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PACKAGE))
                .build()
                .apiInfo(generateApiInfo());
    }

    /**
     * 描述信息
     * @return
     */
    private ApiInfo generateApiInfo() {
        return new ApiInfoBuilder()
                .title("appliance-repair-bs")
                .description("background management system API")
                .build();
    }

}
