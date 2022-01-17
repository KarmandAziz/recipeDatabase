package com.example.recipeDatabase.model.form;

import com.example.recipeDatabase.model.constants.Measurement;
import com.example.recipeDatabase.validation.OnPost;
import com.example.recipeDatabase.validation.OnPut;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import static com.example.recipeDatabase.validation.message.ValidationMessages.MANDATORY_FIELD;

public class RecipeIngredientForm implements Serializable {

    @NotBlank(message = MANDATORY_FIELD ,groups = OnPost.class)
    private String id;

    @NotBlank(message = MANDATORY_FIELD, groups = {OnPost.class, OnPut.class})
    private double amount;


    private Measurement measurement;



    public RecipeIngredientForm() {
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

}
