package com.example.recipeDatabase.data.dataDAO;

import com.example.recipeDatabase.model.constants.Measurement;
import com.example.recipeDatabase.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientDAO extends JpaRepository<Ingredient, String> {

    List<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);
    List<Ingredient> findByIngredientNameLike(String ingredientName);


}
