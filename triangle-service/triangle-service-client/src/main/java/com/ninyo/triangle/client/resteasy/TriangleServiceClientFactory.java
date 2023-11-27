package com.ninyo.triangle.client.resteasy;

import com.ninyo.client.resteasy.ResteasyClientFactory;

public class TriangleServiceClientFactory {
    public TriangleServiceClient createClient(String serviceUrl) {
        return ResteasyClientFactory.createClient(TriangleServiceClient.class, serviceUrl);
    }
}