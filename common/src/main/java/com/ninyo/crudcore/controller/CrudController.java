package com.ninyo.crudcore.controller;

import com.ninyo.crudcore.responses.DtoResponse;
import com.ninyo.crudcore.responses.IdResponse;
import com.ninyo.crudcore.responses.ListResponse;

public interface CrudController<DTO> {

    IdResponse create(DTO dto);

    DtoResponse<DTO> read(long id);

    ListResponse<DTO> readAll();

    void update(long id, DTO dto);

}