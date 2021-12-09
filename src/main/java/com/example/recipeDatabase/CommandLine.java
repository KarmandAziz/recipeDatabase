package com.example.recipeDatabase;

import com.example.recipeDatabase.data.IngredientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLine implements CommandLineRunner {

    private IngredientDAO ingredientDAO;

    @Autowired
    public CommandLine(IngredientDAO ingredientDAO) {
        this.ingredientDAO = ingredientDAO;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
