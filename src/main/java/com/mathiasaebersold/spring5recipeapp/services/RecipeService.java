package com.mathiasaebersold.spring5recipeapp.services;

import com.mathiasaebersold.spring5recipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {
    public Set<Recipe> getRecipes();
}
