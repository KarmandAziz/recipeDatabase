package com.example.recipeDatabase;

import com.example.recipeDatabase.data.IngredientDAO;
import com.example.recipeDatabase.model.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CommandLine implements CommandLineRunner {

    private IngredientDAO ingredientDAO;

    @Autowired
    public CommandLine(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    public void run(String... args) throws Exception {
        Ingredient ingredient = ingredientDAO.save(new Ingredient(null, "salt"));
        ingredientDAO.save(new Ingredient(null, "peppar"));


        List<Ingredient> result = ingredientDAO.findByIngredientNameIgnoreCase("salt");
        result.forEach(System.out::println);

        Optional<Ingredient> result2  = ingredientDAO.findByIngredientNameLike("peppar");
        result2.ifPresent(System.out::println);

    }
}
