package com.example.recipeDatabase.data;

import com.example.recipeDatabase.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDAO extends JpaRepository<Recipe, String> {
    List<Recipe> findByRecipeNameContaining(String recipeName);
}
