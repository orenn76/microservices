package com.mprest.data.injector.config;

import com.mprest.triangle.client.TriangleServiceClient;
import com.mprest.triangle.client.TriangleServiceClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Slf4j
@Configuration
public class RestClientConfig {

    @Bean
    @Autowired
    public TriangleServiceClient triangleServiceClient(Jackson2ObjectMapperBuilder jacksonBuilder, @Value("${triangleServiceClientUrl:http://localhost:8090}") String triangleServiceClientUrl) {
        try {
            log.info("triangleServiceClientUrl host: {}", triangleServiceClientUrl);
            return new TriangleServiceClientFactory().createClient(triangleServiceClientUrl);
        } catch (Throwable ex) {
            throw ex;
        }
    }
}
