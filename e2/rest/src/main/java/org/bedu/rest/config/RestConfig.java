package org.bedu.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RestConfig implements WebMvcConfigurer {

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer){
        // Configuracion por paquete
        //configurer.addPathPrefix("/api/v1", HandlerTypePredicate.forBasePackage("org.bedu.rest.controller"));

        // Configuracion por anotacion
        configurer.addPathPrefix("/api/v1", HandlerTypePredicate.forAnnotation(RestController.class));
        // /api/v1/test
    }
}
