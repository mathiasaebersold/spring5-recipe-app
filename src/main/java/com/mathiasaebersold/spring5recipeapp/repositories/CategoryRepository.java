package com.mathiasaebersold.spring5recipeapp.repositories;

import com.mathiasaebersold.spring5recipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
