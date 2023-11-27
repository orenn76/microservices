package com.ninyo.triangle.controller;

import com.ninyo.crudcore.controller.BaseCrudController;
import com.ninyo.triangle.model.Triangle;
import com.ninyo.triangle.model.TriangleDto;
import com.ninyo.triangle.service.TriangleService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriangleServiceController extends BaseCrudController<TriangleDto, Triangle, TriangleService> {
}