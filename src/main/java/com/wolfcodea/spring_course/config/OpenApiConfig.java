package com.wolfcodea.spring_course.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("APIRest Java Course")
                                .version("V1")
                                .description("Course using spring boot")
                                .termsOfService("https://rodrigosilvafolio.com/home")
                                .license(
                                        new License()
                                                .name("Apache 2.0")
                                                .url("https://rodrigosilvafolio.com/home")));
    }
}
