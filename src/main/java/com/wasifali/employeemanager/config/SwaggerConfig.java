package com.wasifali.employeemanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wasifali.employeemanager"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Employee Manager",
                "Swagger Implementation",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Wasif","https://abc.com","wasifali591@gmail.com"),
                "Api License",
                "https://abc.com",
                Collections.emptyList());

    }


}
