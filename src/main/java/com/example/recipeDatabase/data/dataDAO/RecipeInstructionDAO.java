package com.example.recipeDatabase.data.dataDAO;

import com.example.recipeDatabase.model.entity.RecipeInstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeInstructionDAO extends JpaRepository<RecipeInstruction, String> {
}
