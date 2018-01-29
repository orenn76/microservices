package com.mprest.triangle.service;

import com.mprest.crudcore.service.BaseCrudService;
import com.mprest.triangle.mappers.TriangleDtoToEntityMapper;
import com.mprest.triangle.mappers.TriangleEntityToDtoConverter;
import com.mprest.triangle.model.TriangleDto;
import com.mprest.triangle.model.Triangle;
import com.mprest.triangle.repository.TriangleRepository;
import org.springframework.stereotype.Service;

@Service
public class TriangleServiceImpl extends BaseCrudService<
        TriangleDto,
        Triangle,
        TriangleRepository,
        TriangleDtoToEntityMapper,
        TriangleEntityToDtoConverter> implements TriangleService {
}
