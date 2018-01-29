package com.mprest.triangle.mappers;

import com.mprest.crudcore.mappers.Converter;
import com.mprest.triangle.model.Triangle;
import com.mprest.triangle.model.TriangleDto;
import org.springframework.stereotype.Component;

@Component
public class TriangleEntityToDtoConverter implements Converter<Triangle, TriangleDto> {

    @Override
    public TriangleDto convert(Triangle source) {
        return TriangleDto.builder()
                .id(source.getId())
                .adjacent(source.getAdjacent())
                .opposite(source.getOpposite())
                .hypotenuse(source.getHypotenuse())
                .state(source.getState())
                .build();
    }

}
