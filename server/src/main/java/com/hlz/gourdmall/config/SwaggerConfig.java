package com.hlz.gourdmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author: Davion
 * @date: 2019/11/22
 * @description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment){
        Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("Davion");
        // 作者信息
        Contact contact = new Contact("", "", "");
        // 文档基本信息
        ApiInfo apiInfo = new ApiInfo(
                "接口文档",
                "The GroudMail Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
        // 获取当前运行环境是否为开发环境，如果是，则开启swagger文档
        Profiles profiles = Profiles.of("dev", "test");
        boolean isDev = environment.acceptsProfiles(profiles);
        // 文档配置
        docket.apiInfo(apiInfo)
                .enable(isDev)
                .select()
                //配置可扫描包
                .apis(RequestHandlerSelectors.basePackage("com.hlz.gourdmall.controller"))
                .build();
        return docket;
    }
}
