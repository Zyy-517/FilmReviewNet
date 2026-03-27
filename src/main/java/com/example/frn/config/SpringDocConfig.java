package com.example.frn.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author JoeZhou
 */
@Configuration
public class SpringDocConfig {

    private static final String AUTHOR = "zyy";
    private static final String URL = "http://localhost:8080";
    private static final String TITLE = "莹莹影评网";
    private static final String INFO = "提供影院资讯、购票、影评、在线观看影评等功能。。。";
    private static final String VERSION = "1.0.0";

    /**
     * 通用信息Bean
     */
    /** 通用信息Bean */
    @Bean
    public OpenAPI commonInfo() {
        return new OpenAPI().info(new Info()
                .title(TITLE)
                .description(INFO)
                .version(VERSION)
                .contact(new Contact().name(AUTHOR).url(URL)));
    }
}