package com.example.recipeDatabase.model.entity;

import com.example.recipeDatabase.model.constants.Measurement;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static com.example.recipeDatabase.model.constants.EntityConstants.GENERATOR;
import static com.example.recipeDatabase.model.constants.EntityConstants.UUID_GENERATOR;

@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(generator = GENERATOR)
    @GenericGenerator(name = GENERATOR, strategy = UUID_GENERATOR)
    private String id;
    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_ingredient_id")
    private Ingredient ingredient;
    private double amount;
    private Measurement measurement;
    @ManyToOne(
            cascade = {CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    private Recipe recipe;

    public RecipeIngredient() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
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
}
