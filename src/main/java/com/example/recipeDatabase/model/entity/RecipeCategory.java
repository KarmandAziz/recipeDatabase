package com.example.recipeDatabase.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.Objects;
import java.util.Set;

import static com.example.recipeDatabase.model.constants.EntityConstants.GENERATOR;
import static com.example.recipeDatabase.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class RecipeCategory {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String id;
    private String category;
    @ManyToMany(
            cascade = {CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY,
            mappedBy = "categories"
    )
    private Set<Recipe> recipes;

    public RecipeCategory(String id, String category, Set<Recipe> recipes) {
        this.id = id;
        this.category = category;
        this.recipes = recipes;
    }

    public RecipeCategory() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeCategory that = (RecipeCategory) o;
        return Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category);
    }

    @Override
    public String toString() {
        return "RecipeCategory{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
