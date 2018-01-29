package com.mprest.crudcore.repository;

import com.mprest.crudcore.model.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository<ENTITY extends BaseEntity> extends CrudRepository<ENTITY, Long>, PagingAndSortingRepository<ENTITY, Long> {
}
