package com.zfcgdbinterface.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 注册拦截器
 * @author zht
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**上传地址*/
    @Value("${file.download.picPath}")
    private String picPath;

    /**显示相对地址*/
    @Value("${file.download.picRelativePath}")
    private String picRelativePath;

    /**
     * 配置虚拟目录到物理路径的映射关系
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(picRelativePath).addResourceLocations("file:" + picPath);
        super.addResourceHandlers(registry);
    }
}
