package com.example.recipeDatabase.service.facade.interfaces;

import com.example.recipeDatabase.model.dto.form.IngredientForm;
import com.example.recipeDatabase.model.dto.form.RecipeIngredientForm;
import com.example.recipeDatabase.model.dto.view.IngredientDTO;
import com.example.recipeDatabase.model.entity.Ingredient;
import com.example.recipeDatabase.service.interfaces.GenericEntityService;

public interface IngredientService extends GenericEntityService<IngredientDTO, IngredientForm> {
    IngredientDTO addNewRecipeIngredient(String ingredientId, RecipeIngredientForm recipeIngredientForm);
    IngredientDTO removeRecipeIngredient(String ingredientId, String recipeIngredientId);
}
