package com.mprest.triangle.repository;

import com.mprest.crudcore.repository.BaseRepository;
import com.mprest.triangle.model.Triangle;
import org.springframework.stereotype.Repository;

@Repository
public interface TriangleRepository extends BaseRepository<Triangle> {
}
