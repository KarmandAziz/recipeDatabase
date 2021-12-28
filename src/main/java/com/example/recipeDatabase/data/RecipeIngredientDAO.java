package com.example.recipeDatabase.data;

import com.example.recipeDatabase.model.entity.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeIngredientDAO extends JpaRepository<RecipeIngredient, String> {

}
