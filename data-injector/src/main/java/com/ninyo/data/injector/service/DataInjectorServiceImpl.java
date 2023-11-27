package com.ninyo.data.injector.service;

import com.ninyo.triangle.client.feign.TriangleServiceClient;
import com.ninyo.triangle.model.TriangleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataInjectorServiceImpl implements DataInjectorService {

    @Autowired
    TriangleServiceClient triangleServiceClient;

    public void create(TriangleDto triangleDto) {
        triangleServiceClient.create(triangleDto);
    }
}
