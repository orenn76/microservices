package com.mprest.crudcore.controller;

import com.mprest.crudcore.responses.DtoResponse;
import com.mprest.crudcore.responses.IdResponse;
import com.mprest.crudcore.responses.ListResponse;

import java.util.List;

public interface CrudController<DTO> {

    IdResponse create(DTO dto);

    DtoResponse<DTO> read(long id);

    ListResponse<DTO> readAll();

    void update(long id, DTO dto);

}