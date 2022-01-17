package com.example.recipeDatabase.model.dto.view;

import com.example.recipeDatabase.model.constants.Measurement;
import com.example.recipeDatabase.model.entity.Ingredient;
import com.example.recipeDatabase.model.entity.Recipe;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class RecipeIngredientDTO implements Serializable {

    private String id;
    private double amount;
    private Measurement measurement;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Recipe recipe;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Ingredient ingredient;

    public RecipeIngredientDTO(String id, double amount, Measurement measurement, Recipe recipe, Ingredient ingredient) {
        this.id = id;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
        this.ingredient = ingredient;
    }

    public RecipeIngredientDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
