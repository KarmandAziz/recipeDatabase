package com.example.recipeDatabase.model.dto.view;

import com.example.recipeDatabase.model.entity.RecipeCategory;
import com.example.recipeDatabase.model.entity.RecipeIngredient;
import com.example.recipeDatabase.model.entity.RecipeInstruction;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class RecipeDTO implements Serializable {

    private String id;
    private String recipeName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<RecipeIngredientDTO> recipeIngredients;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RecipeInstructionDTO instructions;
    private List<RecipeCategoryDTO> categories;

    public RecipeDTO(String id, String recipeName, List<RecipeIngredientDTO> recipeIngredients, RecipeInstructionDTO instructions, List<RecipeCategoryDTO> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instructions = instructions;
        this.categories = categories;
    }

    public RecipeDTO() {
    }

    public List<RecipeCategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategoryDTO> categories) {
        this.categories = categories;
    }

    public RecipeInstructionDTO getInstructions() {
        return instructions;
    }

    public void setInstructions(RecipeInstructionDTO instructions) {
        this.instructions = instructions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredientDTO> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredientDTO> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstructionDTO getInstructionDTO() {
        return instructions;
    }

    public void setInstructionDTO(RecipeInstructionDTO instructionDTO) {
        this.instructions = instructionDTO;
    }
}

