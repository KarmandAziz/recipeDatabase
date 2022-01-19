package com.example.recipeDatabase.model.dto.view;

import com.example.recipeDatabase.model.entity.Recipe;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class RecipeCategoryDTO implements Serializable {

    private String id;
    private String category;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<RecipeDTO> recipes;

    public RecipeCategoryDTO(String id, String category, List<RecipeDTO> recipes) {
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

    public List<RecipeDTO> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeDTO> recipes) {
        this.recipes = recipes;
    }
}
