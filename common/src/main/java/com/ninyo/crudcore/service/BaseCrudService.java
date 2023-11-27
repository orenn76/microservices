package com.ninyo.crudcore.service;

import com.ninyo.crudcore.mappers.Converter;
import com.ninyo.crudcore.mappers.Mapper;
import com.ninyo.crudcore.model.BaseEntity;
import com.ninyo.crudcore.repository.BaseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Slf4j
public abstract class BaseCrudService<
        DTO,
        ENTITY extends BaseEntity,
        REPOSITORY extends BaseRepository<ENTITY>,
        DTO_TO_ENTITY_MAPPER extends Mapper<DTO, ENTITY>,
        ENTITY_TO_DTO_CONVERTER extends Converter<ENTITY, DTO>>
        implements CrudService<DTO, ENTITY> {

    @Autowired
    protected REPOSITORY repository;

    @Autowired
    protected DTO_TO_ENTITY_MAPPER dtoToEntityMapper;

    @Autowired
    protected ENTITY_TO_DTO_CONVERTER entityToDtoConverter;

    @SuppressWarnings("unchecked")
    public final Class<ENTITY> runtimeEntity = (Class<ENTITY>) ((ParameterizedType) getClass().getGenericSuperclass())
            .getActualTypeArguments()[1];

    @Override
    public long create(DTO dto) {
        log.info("Start creating entity");
        ENTITY entity = createInstanceOfEntity();
        dtoToEntityMapper.map(dto, entity);
        entity = repository.save(entity);
        log.info("Created entity and saved with id: {}", entity.getId());
        return entity.getId();
    }

    @Override
    public DTO read(long id) {
        log.info("Start reading entity with id: {}", id);
        ENTITY entity = repository.findById(id).orElse(null);
        assertNotNull(entity);
        log.info("Read entity with id: {}", id);
        return entityToDtoConverter.convert(entity);
    }

    @Override
    public List<DTO> readAll() {
        log.info("Start listing entities");
        Iterable<ENTITY> entities  = repository.findAll();
        List<DTO> dtoList =  entityToDtoConverter.convert(entities);
        log.info("Read entities of size: {}", dtoList.size());
        return dtoList;
    }

    @Override
    public void update(long id, DTO dto) {
        log.info("Start updating entity with id: {}", id);
        ENTITY entity = repository.findById(id).orElse(null);
        assertNotNull(entity, id);
        dtoToEntityMapper.map(dto, entity);
        repository.save(entity);
        log.info("Updated entity with id: {}", id);
    }

    private ENTITY createInstanceOfEntity() {
        try {
            return runtimeEntity.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException("Could not create instance of class:" + runtimeEntity, e);
        }
    }

    private void assertNotNull(Iterable<ENTITY> entities) {
        if (entities == null || !entities.iterator().hasNext()) {
            throw new EntityNotFoundException("Entities of type: " + runtimeEntity.getSimpleName() + " were not found for input id list");
        }
        entities.forEach(entity -> {
            assertNotNull(entity);
        });
    }

    private void assertNotNull(ENTITY entity, long id) {
        if (entity == null) {
            throw new EntityNotFoundException(
                    "Entity of type: " + runtimeEntity.getSimpleName() + " entity with id: " + id + " doesn't exist!");
        }
    }

    private void assertNotNull(ENTITY entity) {
        if (entity == null) {
            throw new EntityNotFoundException(
                    "Entity of type: " + runtimeEntity.getSimpleName() + " doesn't exist!");
        }
    }

}
