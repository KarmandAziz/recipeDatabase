package com.example.recipeDatabase.service.interfaces;

import com.example.recipeDatabase.model.dto.form.RecipeForm;
import com.example.recipeDatabase.model.dto.form.RecipeInstructionForm;
import com.example.recipeDatabase.model.entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RecipeEntityService extends GenericEntityService<Recipe, RecipeForm> {

    Recipe addRecipeCategory(String id, String categoryId);
    Recipe removeRecipeCategory(String id, String categoryId);
    List<Recipe> findByRecipeNameContaining(String recipeName);
    List<Recipe> searchByRecipeName(String name);
    List<Recipe> searchByCategory(String category);
    Set<Recipe> searchByAnyCategories(String... categories);
}
