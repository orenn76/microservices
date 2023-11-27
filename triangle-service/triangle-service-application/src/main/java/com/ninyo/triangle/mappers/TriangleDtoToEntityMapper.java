package com.ninyo.triangle.mappers;

import com.ninyo.crudcore.mappers.Mapper;
import com.ninyo.triangle.model.TriangleDto;
import com.ninyo.triangle.model.Triangle;
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
