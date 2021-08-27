package one.digitalinnovation.personapi.configuration;

import org.springframework.context.annotation.Bean;
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
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("one.digitalnnovation.personapi.controller"))
                .paths(PathSelectors.ant("/api/*/*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "System for managing people",
                "API REST MANAGING PEOPLE",
                "1.0",
                "Terms of Service",
                new Contact("Rodrigo Gambarra da Silva", "",
                        "rodrigo@gambarra.com.br"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", Collections.emptyList()
        );
        return apiInfo;
    }
}
