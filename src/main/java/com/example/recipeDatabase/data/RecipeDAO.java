package com.example.recipeDatabase.data;

import com.example.recipeDatabase.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface RecipeDAO extends JpaRepository<Recipe, String> {

    @Query("SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE UPPER(CONCAT('%',:recipeName,'%'))")
    List<Recipe> findByRecipeNameContaining(String recipeName);

    List<Recipe> findByRecipeIngredientsContaining(String ingredientName);

    @Query("SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE UPPER(CONCAT('%',:name,'%') ) ")
    List<Recipe> searchByRecipeName(String name);

    @Query("SELECT r.recipes FROM RecipeCategory r WHERE r.category = :category ")
    List<Recipe> searchByCategory( String category);

    @Query("SELECT r.recipes FROM RecipeCategory r WHERE r.category IN :categories")
    Set<Recipe> searchByAnyCategories(String... categories);
}
