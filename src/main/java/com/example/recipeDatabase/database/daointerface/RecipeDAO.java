package com.example.recipeDatabase.database.daointerface;

import com.example.recipeDatabase.model.entity.Recipe;
import com.example.recipeDatabase.model.entity.RecipeIngredient;

import java.util.List;
import java.util.Set;

public interface RecipeDAO extends DAOGenericCRUD <Recipe, String>{

    List<Recipe> findByRecipeName(String recipeName);
    List<RecipeIngredient> findAllByRecipeIngredient(String recipeIngredient);
    List<Recipe> findByIngredientName(String ingredientName);
    List<Recipe> findAllByCategories(String category);
    Set<Recipe> findByAnyCategories(String... categories);



}
