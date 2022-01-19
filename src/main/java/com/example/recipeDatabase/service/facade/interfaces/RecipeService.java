package com.example.recipeDatabase.service.facade.interfaces;

import com.example.recipeDatabase.model.dto.form.RecipeForm;
import com.example.recipeDatabase.model.dto.view.RecipeDTO;
import com.example.recipeDatabase.service.interfaces.GenericEntityService;

public interface RecipeService extends GenericEntityService<RecipeDTO, RecipeForm> {
}
