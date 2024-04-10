package com.zfcgdbinterface.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 跨域访问
 * @author zht
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径
        //allowedOrigins：允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，
        //      如：“http://www.aaa.com”，只有该域名可以访问我们的跨域资源。
        // allowedMethods：允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等。
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);
    }
}