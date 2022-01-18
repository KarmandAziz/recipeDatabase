package com.example.recipeDatabase.service.facade.implementations;

import com.example.recipeDatabase.model.dto.view.*;
import com.example.recipeDatabase.model.entity.*;
import com.example.recipeDatabase.service.facade.interfaces.DTOService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Component
@Transactional
public class EntityToDTOConverter implements DTOService {

    @Override
    public AppUserDTO toFullAppUserDTO(AppUser appUser) {
        if(appUser == null) return null;
        AppUserDTO appUserDTO = toSmallAppUserDTO(appUser);
        appUserDTO.setRoles(
                appUser.getRoles().stream()
                        .map(AppRole::getUserRole)
                        .collect(Collectors.toList())
        );
        return appUserDTO;
    }


    @Override
    public AppUserDTO toSmallAppUserDTO(AppUser appUser) {
        if(appUser == null) return null;
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setId(appUser.getId());
        appUserDTO.setUsername(appUser.getUsername());
        return appUserDTO;
    }

    @Override
    public RecipeIngredientDTO toFullRecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        if(recipeIngredient == null) return null;
        RecipeIngredientDTO recipeIngredientDTO = toSmallRecipeIngredientDTO(recipeIngredient);
        recipeIngredientDTO.setRecipe(toSmallRecipeDTO(recipeIngredient.getRecipe()));
        return recipeIngredientDTO;
    }

    @Override
    public RecipeIngredientDTO toSmallRecipeIngredientDTO(RecipeIngredient recipeIngredient) {
        if(recipeIngredient == null) return null;
        RecipeIngredientDTO recipeIngredientDTO = new RecipeIngredientDTO();
        recipeIngredientDTO.setId(recipeIngredient.getId());
        recipeIngredientDTO.setAmount(recipeIngredient.getAmount());
        recipeIngredientDTO.setMeasurement(recipeIngredient.getMeasurement());
        return recipeIngredientDTO;
    }

    @Override
    public RecipeDTO toFullRecipeDTO(Recipe recipe) {
        if(recipe == null) return null;
        RecipeDTO recipeDTO = toSmallRecipeDTO(recipe);
        recipeDTO.setInstructions(toRecipeInstructionDTO(recipe.getInstruction()));
        List<RecipeCategoryDTO> recipeCategoryDTOS = recipe.getCategories().stream()
                .map(this::toSmallCategoryDTO)
                .collect(Collectors.toList());

        List<RecipeIngredientDTO> recipeIngredientDTOS = recipe.getRecipeIngredients().stream()
                .map(this::toSmallRecipeIngredientDTO)
                .collect(Collectors.toList());

        recipeDTO.setRecipeIngredients(recipeIngredientDTOS);
        recipeDTO.setCategories(recipeCategoryDTOS);

        return recipeDTO;
    }

    @Override
    public RecipeDTO toSmallRecipeDTO(Recipe recipe) {
        if(recipe == null) return null;
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipe.getId());
        recipeDTO.setRecipeName(recipe.getRecipeName());
        return recipeDTO;
    }

    @Override
    public IngredientDTO toIngredientDTO(Ingredient ingredient) {
        if(ingredient == null) return null;
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setIngredientName(ingredient.getIngredientName());

        return ingredientDTO;
    }

    @Override
    public RecipeCategoryDTO toFullCategoryDTO(RecipeCategory recipeCategory) {
        if(recipeCategory == null) return null;
        RecipeCategoryDTO recipeCategoryDTO = toSmallCategoryDTO(recipeCategory);
        recipeCategoryDTO.setRecipes(recipeCategory.getRecipes());
        return recipeCategoryDTO;

    }

    @Override
    public RecipeCategoryDTO toSmallCategoryDTO(RecipeCategory recipeCategory) {
        if(recipeCategory == null) return null;
        RecipeCategoryDTO recipeCategoryDTO = new RecipeCategoryDTO();
        recipeCategoryDTO.setId(recipeCategory.getId());
        recipeCategoryDTO.setCategory(recipeCategory.getCategory());
        return recipeCategoryDTO;
    }

    @Override
    public RecipeInstructionDTO toRecipeInstructionDTO(RecipeInstruction recipeInstruction) {
        if(recipeInstruction == null) return null;
        RecipeInstructionDTO recipeInstructionDTO = new RecipeInstructionDTO();
        recipeInstructionDTO.setId(recipeInstruction.getId());
        recipeInstructionDTO.setInstructions(recipeInstruction.getInstructions());
        return recipeInstructionDTO;
    }
}
