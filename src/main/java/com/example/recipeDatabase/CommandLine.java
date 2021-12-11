package com.example.recipeDatabase;

import com.example.recipeDatabase.data.IngredientDAO;
import com.example.recipeDatabase.data.RecipeDAO;
import com.example.recipeDatabase.data.RecipeIngredientDAO;
import com.example.recipeDatabase.data.RecipeInstructionDAO;
import com.example.recipeDatabase.model.entity.Ingredient;
import com.example.recipeDatabase.model.entity.Recipe;
import com.example.recipeDatabase.model.entity.RecipeInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommandLine implements CommandLineRunner {

    private IngredientDAO ingredientDAO;
    private RecipeIngredientDAO recipeIngredientDAO;
    private RecipeInstructionDAO recipeInstructionDAO;
    private RecipeDAO recipeDAO;

    @Autowired
    public CommandLine(IngredientDAO ingredientDAO, RecipeIngredientDAO recipeIngredientDAO, RecipeInstructionDAO recipeInstructionDAO, RecipeDAO recipeDAO) {
        this.ingredientDAO = ingredientDAO;
        this.recipeIngredientDAO = recipeIngredientDAO;
        this.recipeInstructionDAO = recipeInstructionDAO;
        this.recipeDAO = recipeDAO;
    }

    @Override
    public void run(String... args) throws Exception {

       Recipe recipe = recipeDAO.save(new Recipe(null,"Pizza", new RecipeInstruction(null, "Bake in oven")));

      List<Recipe> result = recipeDAO.findByRecipeNameContaining("izza");
      result.forEach(System.out::println);





    }
}
