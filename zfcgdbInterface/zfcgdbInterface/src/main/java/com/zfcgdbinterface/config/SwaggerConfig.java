package com.zfcgdbinterface.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *.@ComponentScan(basePackages = {"com.zfcgdbinterface.controller"}):
 *    指定需要生成API文档的类所在的包路径
 *.@EnableSwagger2：swagger2启动注解
 * @author zht
 **/
@EnableSwagger2
@ComponentScan(basePackages = {"com.zfcgdbinterface.controller"})
@Configuration
public class SwaggerConfig {

    /**
     * swagger配置
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("广东履约信用")
                .description("项目接口测试")
                .version("版本:1.0.0")
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .build();
    }
}
