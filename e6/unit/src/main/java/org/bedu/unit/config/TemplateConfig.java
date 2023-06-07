package org.bedu.unit.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TemplateConfig {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate template = new RestTemplate();
        MappingJackson2CborHttpMessageConverter converter = new MappingJackson2CborHttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        template.getMessageConverters().add(converter);
        return template;
    }

}
