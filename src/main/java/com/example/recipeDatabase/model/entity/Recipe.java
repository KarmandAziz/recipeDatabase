package com.example.recipeDatabase.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "recipe"
    )
    private Set<RecipeIngredient> recipeIngredients;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_instruction_id")
    private RecipeInstruction instruction;

    @ManyToMany(
            cascade = {CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            mappedBy = "recipes"
    )
    private Set<RecipeCategory> categories;

    public Recipe(String id, String recipeName, RecipeInstruction instruction) {
        this.id = id;
        this.recipeName = recipeName;
        this.instruction = instruction;
    }

    public Recipe(String recipeName, Set<RecipeIngredient> recipeIngredients, RecipeInstruction instruction) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
    }

    public Recipe() {
    }

    public void addRecipeCategory(RecipeCategory recipeCategory){
        if(recipeCategory == null) throw new IllegalArgumentException("recipeCategory was null!");
        if(categories == null) categories = new HashSet<>();
        if(!categories.contains(recipeCategory)){
            categories.add(recipeCategory);
        }
    }

    public void removeRecipeCategory(RecipeCategory recipeCategory){
        if(recipeCategory == null) throw new IllegalArgumentException("recipeCategory was null!");
        if(categories == null) categories = new HashSet<>();
        if(this.categories.contains(recipeCategory)){
            categories.remove(recipeCategory);
            recipeCategory.setCategory(null);
        }
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
        if(recipeIngredients == null) recipeIngredients = new HashSet<>();
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> recipeCategories) {
        if(recipeCategories == null) recipeCategories = new HashSet<>();
        if(recipeCategories.isEmpty()){
            if(this.categories != null){
                this.categories.forEach(recipeCategory -> recipeCategory.setRecipes(null));
            }
        }else{
            recipeCategories.forEach(recipeCategory -> recipeCategory.setRecipes(recipeCategory.getRecipes()));
        }
        this.categories = recipeCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(recipeName, recipe.recipeName) && Objects.equals(instruction, recipe.instruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeName, instruction);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", instruction=" + instruction +
                ", categories=" + categories +
                '}';
    }
}
