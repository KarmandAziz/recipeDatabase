package com.example.recipeDatabase.model.dto.view;

import com.example.recipeDatabase.model.entity.Recipe;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Set;

public class RecipeCategoryDTO implements Serializable {

    private String id;
    private String category;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Recipe> recipes;

    public RecipeCategoryDTO(String id, String category, Set<Recipe> recipes) {
        this.id = id;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategoryDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
