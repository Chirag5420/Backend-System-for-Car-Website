package com.udacity.pricing.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Pricing API",
                "This is a Pricing API",
                "1.0",
                "http://www.udacity.com/tos",
                new Contact("Chirag Chhajlani", "www.vehicleapi.com", "chiragchhajlani3@gmail.com"),
                "License of API", "http://www.udacity.com/license", Collections.emptyList()
        );
    }
}
