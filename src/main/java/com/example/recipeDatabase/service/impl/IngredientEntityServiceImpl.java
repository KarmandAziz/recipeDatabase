package com.example.recipeDatabase.service.impl;

import com.example.recipeDatabase.model.dto.form.IngredientForm;
import com.example.recipeDatabase.model.entity.Ingredient;
import com.example.recipeDatabase.service.GenericEntityService;
import com.example.recipeDatabase.service.IngredientEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IngredientEntityServiceImpl implements IngredientEntityService {


    @Override
    public Ingredient create(IngredientForm ingredientForm) {
        return null;
    }

    @Override
    public Ingredient findById(String id) {
        return null;
    }

    @Override
    public List<Ingredient> findAll() {
        return null;
    }

    @Override
    public Ingredient update(String id, IngredientForm ingredientForm) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
