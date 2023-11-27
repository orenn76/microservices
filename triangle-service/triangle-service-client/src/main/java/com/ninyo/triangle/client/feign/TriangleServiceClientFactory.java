package com.ninyo.triangle.client.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ninyo.client.feign.FeignClientFactory;
import com.ninyo.triangle.client.feign.exception.ClientErrorDecoder;
import feign.jackson.JacksonDecoder;

public class TriangleServiceClientFactory {

    public TriangleServiceClient createClient(String serviceUrl, ObjectMapper objectMapper) {
        return FeignClientFactory.createClient(TriangleServiceClient.class, serviceUrl, objectMapper, new ClientErrorDecoder(new JacksonDecoder(objectMapper)));
    }
}
