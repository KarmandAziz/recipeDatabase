package com.example.recipeDatabase.data;

import com.example.recipeDatabase.model.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface RecipeDAO extends JpaRepository<Recipe, String> {

    @Query("SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE UPPER(CONCAT('%',:recipeName,'%'))")
    List<Recipe> findByRecipeNameContaining(@Param("recipeName")String recipeName);

    @Query("SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE UPPER(CONCAT('%',:name,'%'))")
    List<Recipe> searchByRecipeName(@Param("name") String name);

    @Query("SELECT r.recipes FROM RecipeCategory r WHERE r.category = :category ")
    List<Recipe> searchByCategory(@Param("category") String category);

    @Query("SELECT r.recipes FROM RecipeCategory r WHERE r.category IN :categories")
    List<Recipe> searchByAnyCategories(@Param("categories") String... categories);
}
