package com.example.recipeDatabase;

import com.example.recipeDatabase.data.IngredientDAO;
import com.example.recipeDatabase.data.RecipeDAO;
import com.example.recipeDatabase.data.RecipeIngredientDAO;
import com.example.recipeDatabase.data.RecipeInstructionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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



    }
}
