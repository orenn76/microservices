package com.mprest.crudcore.service;

import com.mprest.crudcore.model.BaseEntity;

import java.util.List;

public interface CrudService<DTO, ENTITY extends BaseEntity> {

    long create(DTO dto);

    DTO read(long id);

    List<DTO> readAll();

    void update(long id, DTO dto);

}
