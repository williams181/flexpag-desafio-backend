package com.flexpag.paymentscheduler.config.swagger;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.flexpag.paymentscheduler.usuario.model.Usuario;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ParameterType;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
    

    @Bean
    public Docket flatUpApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.flexpag.paymentscheduler"))
            .paths(PathSelectors.ant("/**"))
            .build()
            .ignoredParameterTypes(Usuario.class)
            .globalRequestParameters(
                Arrays.asList(
                    new RequestParameterBuilder()
                    .name("Authorization")
                    .description("Access token to flexpag")
                    .required(false)
                    .in(ParameterType.HEADER)
                    .accepts(Collections.singleton(MediaType.APPLICATION_JSON))
                    .build()));
    }
}
