package com.example.recipeDatabase.validation.message;

import com.example.recipeDatabase.data.RecipeDAO;
import com.example.recipeDatabase.model.entity.Recipe;
import com.example.recipeDatabase.validation.UniqueRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
@Component
public class UniqueRecipeValidator implements ConstraintValidator<UniqueRecipe, String>{

    private final RecipeDAO recipeDAO;

    @Autowired
    public UniqueRecipeValidator(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return !recipeDAO.searchByRecipeName(value).isPresent();
    }
}
