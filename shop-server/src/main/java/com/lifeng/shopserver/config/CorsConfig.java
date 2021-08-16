package com.lifeng.shopserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 解决跨域问题。
 * @author minishark
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {



    @Override

    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")

                .allowedOriginPatterns("*")

                .allowCredentials(true)

                .allowedMethods("GET", "POST", "DELETE", "PUT")

                .maxAge(3600);

    }



}
