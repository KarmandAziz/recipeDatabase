package com.example.recipeDatabase.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ingredient {

    @Id
    private String id;
    private String ingredient;

}
