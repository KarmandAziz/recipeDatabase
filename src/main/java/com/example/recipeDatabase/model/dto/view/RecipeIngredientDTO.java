package com.example.recipeDatabase.model.dto.view;

import com.example.recipeDatabase.model.constants.Measurement;
import com.example.recipeDatabase.model.entity.Ingredient;
import com.example.recipeDatabase.model.entity.Recipe;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class RecipeIngredientDTO implements Serializable {

    private String id;
    private double amount;
    private Measurement measurement;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RecipeDTO recipe;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private IngredientDTO ingredient;


    public RecipeIngredientDTO() {
    }

    public RecipeIngredientDTO(String id, double amount, Measurement measurement, RecipeDTO recipe, IngredientDTO ingredient) {
        this.id = id;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
        this.ingredient = ingredient;
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

    public RecipeDTO getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeDTO recipe) {
        this.recipe = recipe;
    }

    public IngredientDTO getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDTO ingredient) {
        this.ingredient = ingredient;
    }
}


