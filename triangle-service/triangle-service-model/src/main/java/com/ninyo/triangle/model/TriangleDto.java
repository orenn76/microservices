package com.ninyo.triangle.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
@JsonDeserialize(builder = TriangleDto.TriangleDtoBuilder.class)
public class TriangleDto {

    private Long id;
    private State state;
    private Integer adjacent;
    private Integer opposite;
    private Integer hypotenuse;

    @JsonPOJOBuilder(withPrefix = "")
    public static final class TriangleDtoBuilder {
    }

}