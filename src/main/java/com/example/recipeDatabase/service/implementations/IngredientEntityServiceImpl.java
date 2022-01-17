package com.example.recipeDatabase.service.implementations;

import com.example.recipeDatabase.data.IngredientDAO;
import com.example.recipeDatabase.data.RecipeIngredientDAO;
import com.example.recipeDatabase.exception.AppResourceNotFoundException;
import com.example.recipeDatabase.model.form.IngredientForm;
import com.example.recipeDatabase.model.entity.Ingredient;
import com.example.recipeDatabase.service.interfaces.IngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientEntityServiceImpl implements IngredientEntityService {

    private final IngredientDAO ingredientDAO;
    private final RecipeIngredientDAO recipeIngredientDAO;

    @Autowired
    public IngredientEntityServiceImpl(IngredientDAO ingredientDAO, RecipeIngredientDAO recipeIngredientDAO) {
        this.ingredientDAO = ingredientDAO;
        this.recipeIngredientDAO = recipeIngredientDAO;
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
}
