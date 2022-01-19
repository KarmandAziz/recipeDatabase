package com.example.recipeDatabase.service.implementations;

import com.example.recipeDatabase.data.IngredientDAO;
import com.example.recipeDatabase.data.RecipeIngredientDAO;
import com.example.recipeDatabase.exception.AppResourceNotFoundException;
import com.example.recipeDatabase.model.dto.form.IngredientForm;
import com.example.recipeDatabase.model.dto.form.RecipeIngredientForm;
import com.example.recipeDatabase.model.entity.Ingredient;
import com.example.recipeDatabase.model.entity.RecipeIngredient;
import com.example.recipeDatabase.service.interfaces.IngredientEntityService;
import com.example.recipeDatabase.service.interfaces.RecipeIngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientEntityServiceImpl implements IngredientEntityService {

    private final IngredientDAO ingredientDAO;
    private final RecipeIngredientEntityService recipeIngredientEntityService;

    @Autowired
    public IngredientEntityServiceImpl(IngredientDAO ingredientDAO, RecipeIngredientEntityService recipeIngredientEntityService) {
        this.ingredientDAO = ingredientDAO;
        this.recipeIngredientEntityService = recipeIngredientEntityService;
    }

    @Override
    public Ingredient create(IngredientForm ingredientForm) {
        if(ingredientForm == null){
            throw new IllegalArgumentException("IngredientForm was null");
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(ingredientForm.getIngredientName());

        return ingredientDAO.save(ingredient);
    }

    @Override
    public Ingredient findById(String id) {
        return ingredientDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find Ingredient with id " +id));
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientDAO.findAll();
    }

    @Override
    public Ingredient update(String id, IngredientForm ingredientForm) {
        Ingredient ingredient = findById(id);
        ingredient.setIngredientName(ingredientForm.getIngredientName());
        ingredient.setId(ingredientForm.getId());

        return ingredientDAO.save(ingredient);

    }

    @Override
    public void delete(String id) {
        Ingredient ingredient = findById(id);
        ingredientDAO.delete(ingredient);

    }

    @Override
    public Ingredient addNewRecipeIngredient(String ingredientId, String recipeIngredientId) {
        Ingredient ingredient = findById(ingredientId);
        RecipeIngredient recipeIngredient = recipeIngredientEntityService.findById(recipeIngredientId);
        ingredient.addNewRecipeIngredient(recipeIngredient);
        ingredient = ingredientDAO.save(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient removeRecipeIngredient(String ingredientId, String recipeIngredientId) {
        Ingredient ingredient = findById(ingredientId);
        RecipeIngredient recipeIngredient = recipeIngredientEntityService.findById(recipeIngredientId);

        ingredient.removeRecipeIngredient(recipeIngredient);
        ingredient = ingredientDAO.save(ingredient);
        return ingredient;
    }

    @Override
    public Ingredient moveRecipeIngredient(String ingredientId, String recipeIngredientId) {
        Ingredient newIngredient = findById(ingredientId);
        RecipeIngredient recipeIngredient = recipeIngredientEntityService.findById(recipeIngredientId);
        Ingredient oldIngredient = recipeIngredient.getIngredient();
        if(oldIngredient != null){
            oldIngredient.removeRecipeIngredient(recipeIngredient);
        }
        newIngredient.addNewRecipeIngredient(recipeIngredient);

        newIngredient = ingredientDAO.save(newIngredient);
        return newIngredient;
    }
}
