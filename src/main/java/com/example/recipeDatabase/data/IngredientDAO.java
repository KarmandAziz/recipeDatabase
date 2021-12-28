package com.example.recipeDatabase.data;

import com.example.recipeDatabase.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientDAO extends JpaRepository<Ingredient, String> {

    List<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);
    List<Ingredient> findByIngredientNameLike(String ingredientName);


}
