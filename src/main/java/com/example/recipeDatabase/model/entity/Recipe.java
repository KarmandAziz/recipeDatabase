package com.example.recipeDatabase.model.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import javax.persistence.*;
import java.util.List;
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
            cascade = {CascadeType.REFRESH,CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "recipe"
    )
    private List<RecipeIngredient> recipeIngredients;

    @OneToOne(
            orphanRemoval = true
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

    public Set<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Set<RecipeCategory> categories) {
        this.categories = categories;
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
