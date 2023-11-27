package com.ninyo.triangle.model;

import com.ninyo.crudcore.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Triangle implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private State state;

    private Integer adjacent;

    private Integer opposite;

    private Integer hypotenuse;

}