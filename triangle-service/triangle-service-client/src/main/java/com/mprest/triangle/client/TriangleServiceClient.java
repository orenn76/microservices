package com.mprest.triangle.client;

import com.mprest.triangle.model.TriangleDto;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path(TriangleServiceClient.PATH)
public interface TriangleServiceClient {

    String PATH = "/triangle-service/";

    @POST
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public abstract Response create(@RequestBody TriangleDto triangleDto);
}
