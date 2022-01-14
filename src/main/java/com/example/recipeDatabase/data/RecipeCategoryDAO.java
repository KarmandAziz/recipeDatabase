package com.example.recipeDatabase.data;

import com.example.recipeDatabase.model.entity.RecipeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeCategoryDAO extends JpaRepository<RecipeCategory, String> {
}
