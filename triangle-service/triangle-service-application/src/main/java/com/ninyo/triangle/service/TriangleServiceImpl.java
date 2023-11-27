package com.ninyo.triangle.service;

import com.ninyo.crudcore.service.BaseCrudService;
import com.ninyo.triangle.mappers.TriangleDtoToEntityMapper;
import com.ninyo.triangle.mappers.TriangleEntityToDtoConverter;
import com.ninyo.triangle.model.TriangleDto;
import com.ninyo.triangle.model.Triangle;
import com.ninyo.triangle.repository.TriangleRepository;
import org.springframework.stereotype.Service;

@Service
public class TriangleServiceImpl extends BaseCrudService<
        TriangleDto,
        Triangle,
        TriangleRepository,
        TriangleDtoToEntityMapper,
        TriangleEntityToDtoConverter> implements TriangleService {
}
