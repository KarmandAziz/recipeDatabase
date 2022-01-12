package com.example.recipeDatabase.service.impl;

import com.example.recipeDatabase.data.RecipeIngredientDAO;
import com.example.recipeDatabase.exception.AppResourceNotFoundException;
import com.example.recipeDatabase.model.dto.form.RecipeForm;
import com.example.recipeDatabase.model.dto.form.RecipeIngredientForm;
import com.example.recipeDatabase.model.entity.Ingredient;
import com.example.recipeDatabase.model.entity.Recipe;
import com.example.recipeDatabase.model.entity.RecipeIngredient;
import com.example.recipeDatabase.service.RecipeEntityService;
import com.example.recipeDatabase.service.RecipeIngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RecipeIngredientEntityServiceImpl implements RecipeIngredientEntityService {

    private final RecipeIngredientDAO recipeIngredientDAO;

    @Autowired
    public RecipeIngredientEntityServiceImpl(RecipeIngredientDAO recipeIngredientDAO) {
        this.recipeIngredientDAO = recipeIngredientDAO;
    }


    @Override
    public RecipeIngredient create(RecipeIngredientForm recipeIngredientForm) {
        if(recipeIngredientForm == null) throw new IllegalArgumentException("RecipeIngredientForm was null");
        RecipeIngredient recipeIngredient = new RecipeIngredient();
        recipeIngredient.setAmount(recipeIngredientForm.getAmount());
        recipeIngredient.setMeasurement(recipeIngredientForm.getMeasurement());

        return recipeIngredientDAO.save(recipeIngredient);
    }

    @Override
    public RecipeIngredient findById(String id) {
        return recipeIngredientDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find RecipeIngredient with id "+ id));
    }

    @Override
    public List<RecipeIngredient> findAll() {
        return recipeIngredientDAO.findAll();
    }

    @Override
    public RecipeIngredient update(String id, RecipeIngredientForm recipeIngredientForm) {
        RecipeIngredient recipeIngredient = findById(id);
        if(!id.equals(recipeIngredientForm.getId())){
            throw new IllegalArgumentException("Id did not match with " + RecipeIngredientForm.class.getName()+".id");
        }
        recipeIngredient.setAmount(recipeIngredientForm.getAmount());
        recipeIngredient.setMeasurement(recipeIngredientForm.getMeasurement());
        recipeIngredient = recipeIngredientDAO.save(recipeIngredient);

        return recipeIngredient;
    }

    @Override
    public void delete(String id) {
        RecipeIngredient recipeIngredient = findById(id);
        recipeIngredient.setIngredient(null);
        recipeIngredientDAO.delete(recipeIngredient);

    }
}
