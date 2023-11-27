package com.ninyo.crudcore.service;

import com.ninyo.crudcore.model.BaseEntity;

import java.util.List;

public interface CrudService<DTO, ENTITY extends BaseEntity> {

    long create(DTO dto);

    DTO read(long id);

    List<DTO> readAll();

    void update(long id, DTO dto);

}
