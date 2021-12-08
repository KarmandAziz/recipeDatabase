package com.example.recipeDatabase.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

import static com.example.recipeDatabase.model.constants.EntityConstants.GENERATOR;
import static com.example.recipeDatabase.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String id;
    private String recipeName;
    @ManyToMany(
            cascade = {CascadeType.REFRESH,CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    private List<RecipeIngredient> recipeIngredients;
    private RecipeInstruction instruction;
    @ManyToMany(
            cascade = {CascadeType.REFRESH, CascadeType.DETACH}

    )
    private List<RecipeCategory> categories;

    public Recipe(String id, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.id = id;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe() {
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

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }
}
