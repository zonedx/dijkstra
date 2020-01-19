package com.zone.dijkstra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author duanxin
 * @className: SwaggerConfig
 * @date 2019-12-26 09:26
 **/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("map","地图Api"),new Tag("path","路径相关"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zone.dijkstra.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DIJKSTRA APIS")
                .description("服务：最短路径计算服务")
//                .termsOfServiceUrl("http://192.168.1.198:10070/platformgroup/ms-admin")
                .version("1.0")
                .build();
    }

}
