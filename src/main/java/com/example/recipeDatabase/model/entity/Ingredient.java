package com.example.recipeDatabase.model.entity;

import com.example.recipeDatabase.model.dto.form.RecipeIngredientForm;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.recipeDatabase.model.constants.EntityConstants.GENERATOR;
import static com.example.recipeDatabase.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    @Column(updatable = false)
    private String id;
    @Column(unique = true)
    private String ingredientName;
    @OneToMany(
            cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            mappedBy = "ingredient"
    )
    private List<RecipeIngredient> recipeIngredients;

    public Ingredient(String id, String ingredientName) {
        this.id = id;
        this.ingredientName = ingredientName;
    }

    public Ingredient() {
    }

    public void addNewRecipeIngredient(RecipeIngredient recipeIngredient){
        if(recipeIngredient == null) throw new IllegalArgumentException("recipeIngredient was null.");
        if(recipeIngredients == null) recipeIngredients = new ArrayList<>();
        if(!recipeIngredients.contains(recipeIngredient)){
            recipeIngredients.add(recipeIngredient);
            recipeIngredient.setIngredient(this);
        }
    }
    public void removeRecipeIngredient(RecipeIngredient recipeIngredient){
        if(recipeIngredient == null) throw new IllegalArgumentException("recipeIngredient was null.");
        if(recipeIngredients == null) recipeIngredients = new ArrayList<>();
        if(this.recipeIngredients.contains(recipeIngredient)){
            recipeIngredients.remove(recipeIngredient);
            recipeIngredient.setIngredient(null);
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(ingredientName, that.ingredientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredientName);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", ingredientName='" + ingredientName + '\'' +
                '}';
    }
}
