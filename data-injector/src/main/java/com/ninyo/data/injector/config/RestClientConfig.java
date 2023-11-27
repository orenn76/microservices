package com.ninyo.data.injector.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ninyo.triangle.client.feign.TriangleServiceClient;
import com.ninyo.triangle.client.feign.TriangleServiceClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RestClientConfig {

    @Bean
    public ObjectMapper objectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper;
    }

    @Bean
    public TriangleServiceClient triangleServiceClient(@Value("${triangleServiceClientUrl:http://localhost:8090/triangle-service}") String triangleServiceClientUrl) {
        try {
            log.info("triangleServiceClientUrl host: {}", triangleServiceClientUrl);
            return new TriangleServiceClientFactory().createClient(triangleServiceClientUrl, objectMapper());
        } catch (Throwable ex) {
            throw ex;
        }
    }

}
