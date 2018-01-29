package com.mprest.triangle.mappers;

import com.mprest.crudcore.mappers.Mapper;
import com.mprest.triangle.model.TriangleDto;
import com.mprest.triangle.model.Triangle;
import org.springframework.stereotype.Component;

@Component
public class TriangleDtoToEntityMapper implements Mapper<TriangleDto, Triangle> {

    public void map(TriangleDto dto, Triangle triangle) {
        triangle.setState(dto.getState());
        triangle.setAdjacent(dto.getAdjacent());
        triangle.setOpposite(dto.getOpposite());
        triangle.setHypotenuse(dto.getHypotenuse());
    }
}
