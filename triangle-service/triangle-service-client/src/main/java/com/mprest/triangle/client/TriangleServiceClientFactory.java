package com.mprest.triangle.client;

import com.mprest.client.RestClientFactory;

public class TriangleServiceClientFactory {
    public TriangleServiceClient createClient(String serviceUrl) {
        return RestClientFactory.createClient(TriangleServiceClient.class, serviceUrl);
    }
}
