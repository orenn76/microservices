package com.mprest.data.injector.service;

import com.mprest.triangle.client.TriangleServiceClient;
import com.mprest.triangle.model.TriangleDto;
import lombok.extern.slf4j.Slf4j;
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
