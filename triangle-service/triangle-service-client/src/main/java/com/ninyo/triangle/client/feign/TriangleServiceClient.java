package com.ninyo.triangle.client.feign;

import com.ninyo.crudcore.responses.IdResponse;
import com.ninyo.triangle.model.TriangleDto;
import feign.Headers;
import feign.RequestLine;

@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface TriangleServiceClient {

    @RequestLine("POST /")
    IdResponse create(TriangleDto triangleDto);
}
