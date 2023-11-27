package com.ninyo.triangle.mappers;

import com.ninyo.crudcore.mappers.Converter;
import com.ninyo.triangle.model.Triangle;
import com.ninyo.triangle.model.TriangleDto;
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
