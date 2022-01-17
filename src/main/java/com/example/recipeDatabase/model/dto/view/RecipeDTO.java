package com.example.recipeDatabase.model.dto.view;

import com.example.recipeDatabase.model.entity.RecipeIngredient;
import com.example.recipeDatabase.model.entity.RecipeInstruction;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Set;

public class RecipeDTO implements Serializable {

    private String id;
    private String recipeName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<RecipeIngredient> recipeIngredients;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RecipeInstruction instruction;

    public RecipeDTO(String id, String recipeName, Set<RecipeIngredient> recipeIngredients, RecipeInstruction instruction) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
    }

    public RecipeDTO() {
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

    public Set<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(Set<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }
}
