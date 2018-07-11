package com.mtty.igood.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Desp 解决请求cors跨域问题
 * @Date 2018/1/27
 * @Author mtty
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 默认拦截所有请求
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }
}
