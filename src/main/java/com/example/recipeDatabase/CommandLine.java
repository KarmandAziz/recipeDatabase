package com.example.recipeDatabase;

import com.example.recipeDatabase.data.IngredientDAO;
import com.example.recipeDatabase.data.RecipeDAO;
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
    private RecipeDAO recipeDAO;

    @Autowired
    public CommandLine(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    @Override
    public void run(String... args) throws Exception {

        RecipeInstruction recipeInstruction = new RecipeInstruction(null, "Bake in oven");
        Recipe recipe = recipeDAO.save(new Recipe(null,"Pizza", recipeInstruction));


        List<Recipe> result = recipeDAO.findByRecipeName("Pizza");
        result.forEach(System.out::println);





    }
}
