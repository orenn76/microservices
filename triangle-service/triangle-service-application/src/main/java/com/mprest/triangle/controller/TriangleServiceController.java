package com.mprest.triangle.controller;

import com.mprest.crudcore.controller.BaseCrudController;
import com.mprest.triangle.model.TriangleDto;
import com.mprest.triangle.model.Triangle;
import com.mprest.triangle.service.TriangleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleServiceController extends BaseCrudController<TriangleDto, Triangle, TriangleService> {
}