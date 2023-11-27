package com.ninyo.triangle.repository;

import com.ninyo.crudcore.repository.BaseRepository;
import com.ninyo.triangle.model.Triangle;
import org.springframework.stereotype.Repository;

@Repository
public interface TriangleRepository extends BaseRepository<Triangle> {
}
