//package com.world.countries.data.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.Collections;
//
//    @Configuration
//    public class SpringFoxConfig {
//        @Bean
//        public Docket swaggerConfiguration() {
//            return new Docket(DocumentationType.SWAGGER_2)
//                    .select()
//                    .paths(PathSelectors.ant("/**"))
//                    .apis(RequestHandlerSelectors.basePackage("com.world.countries"))
//                    .build().apiInfo(apiDetails());
//        }
//
//        private ApiInfo apiDetails() {
//            return new ApiInfo(
//                    "Countries Api Documentation",
//                    "",
//                    "1.0",
//                    "Terms of service",
//                    new Contact("Morenike", "https://github.com/oluwashetemipe", "oluwashetemipe@gmail.com"),
//                    "License of API", "API license URL", Collections.emptyList());
//        }
//    }

