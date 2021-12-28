package com.example.recipeDatabase.database;

import com.example.recipeDatabase.model.entity.Ingredient;

import java.util.List;

public interface IngredientDAO extends DAOGenericCRUD <Ingredient, String> {
    List<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);
    List<Ingredient> findByIngredientNameLike(String ingredientName);
}
