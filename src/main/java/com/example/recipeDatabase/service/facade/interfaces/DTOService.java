package com.example.recipeDatabase.service.facade.interfaces;

import com.example.recipeDatabase.model.dto.view.*;
import com.example.recipeDatabase.model.entity.*;

public interface DTOService {

    AppUserDTO toFullAppUserDTO(AppUser appUser);
    AppUserDTO toSmallAppUserDTO(AppUser appUser);

    RecipeIngredientDTO toFullRecipeIngredientDTO(RecipeIngredient recipeIngredient);
    RecipeIngredientDTO toSmallRecipeIngredientDTO(RecipeIngredient recipeIngredient);

    RecipeDTO toFullRecipeDTO (Recipe recipe);
    RecipeDTO toSmallRecipeDTO(Recipe recipe);

    IngredientDTO toIngredientDTO(Ingredient ingredient);

    RecipeCategoryDTO toFullRecipeCategoryDTO(RecipeCategory recipeCategory);
    RecipeCategoryDTO toSmallRecipeCategoryDTO(RecipeCategory recipeCategory);

    RecipeInstructionDTO toRecipeInstructionDTO(RecipeInstruction recipeInstruction);

}
