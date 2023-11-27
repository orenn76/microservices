package com.ninyo.client.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.codec.ErrorDecoder;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.stereotype.Service;

@Service
public class FeignClientFactory {

    public static <T> T createClient(Class<T> type, String serviceUrl, ObjectMapper objectMapper, ErrorDecoder errorDecoder) {
        return Feign.builder()
                .logger(new Slf4jLogger(type))
                .client(new ApacheHttpClient())
                .decoder(new JacksonDecoder(objectMapper))
                .encoder(new JacksonEncoder(objectMapper))
                .errorDecoder(errorDecoder)
                .target(type, serviceUrl);
    }
}
