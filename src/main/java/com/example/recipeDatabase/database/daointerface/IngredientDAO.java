package com.example.recipeDatabase.database.daointerface;

import com.example.recipeDatabase.database.daointerface.DAOGenericCRUD;
import com.example.recipeDatabase.model.entity.Ingredient;

import java.util.List;

public interface IngredientDAO extends DAOGenericCRUD<Ingredient, String> {
    List<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);
    List<Ingredient> findByIngredientNameLike(String ingredientName);
}
