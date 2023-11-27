package com.ninyo.crudcore.controller;

import com.ninyo.crudcore.model.BaseEntity;
import com.ninyo.crudcore.responses.*;
import com.ninyo.crudcore.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Base class for CRUD controllers.
 */
public abstract class BaseCrudController<
        DTO,
        ENTITY extends BaseEntity,
        SERVICE extends CrudService<DTO, ENTITY>>
        implements CrudController<DTO> {

    public static final String ID_PATTERN = "/{id}";

    @Autowired
    protected SERVICE service;

    @Override
    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponse create(@RequestBody DTO dto) {
        return new IdResponse(service.create(dto));
    }

    @Override
    @RequestMapping(value = ID_PATTERN, method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public DtoResponse<DTO> read(@PathVariable long id) {
        DTO dto = service.read(id);
        return new DtoResponse<>(dto);
    }

    @Override
    @RequestMapping(value = "/", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<DTO> readAll() {
        List<DTO> dtoList = service.readAll();
        return new ListResponse<>(dtoList);
    }

    @Override
    @RequestMapping(value = ID_PATTERN, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable long id, @RequestBody DTO dto) {
        service.update(id, dto);
    }

}
