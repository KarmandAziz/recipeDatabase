package com.example.recipeDatabase.service.facade.interfaces;

import com.example.recipeDatabase.model.dto.form.RecipeForm;
import com.example.recipeDatabase.model.dto.view.RecipeDTO;
import com.example.recipeDatabase.model.entity.Recipe;
import com.example.recipeDatabase.service.interfaces.GenericEntityService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RecipeService extends GenericEntityService<RecipeDTO, RecipeForm> {

    RecipeDTO addRecipeCategory(String id, String categoryId);
    RecipeDTO removeRecipeCategory(String id, String categoryId);
    List<RecipeDTO> findByRecipeNameContaining(String recipeName);
    RecipeDTO searchByRecipeName(String name);
    List<RecipeDTO> searchByCategory(String category);
    List<RecipeDTO> searchByAnyCategories(String... categories);
}
