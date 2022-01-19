package com.example.recipeDatabase.service.interfaces;

import com.example.recipeDatabase.model.dto.form.IngredientForm;
import com.example.recipeDatabase.model.dto.form.RecipeIngredientForm;
import com.example.recipeDatabase.model.entity.Ingredient;

public interface IngredientEntityService extends GenericEntityService<Ingredient, IngredientForm> {

    Ingredient addNewRecipeIngredient(String ingredientId, String recipeIngredientId);
    Ingredient removeRecipeIngredient(String ingredientId, String recipeIngredientId);
    Ingredient moveRecipeIngredient(String ingredientId, String recipeIngredientId);

}
