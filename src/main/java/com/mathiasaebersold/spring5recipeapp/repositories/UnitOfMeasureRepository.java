package com.mathiasaebersold.spring5recipeapp.repositories;

import com.mathiasaebersold.spring5recipeapp.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
}
