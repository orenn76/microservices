package com.mprest.triangle.model;

import com.mprest.crudcore.model.BaseEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

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