package com.example.recipeDatabase.service.implementations;

import com.example.recipeDatabase.model.form.RecipeForm;
import com.example.recipeDatabase.model.entity.Recipe;
import com.example.recipeDatabase.service.interfaces.RecipeEntityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RecipeEntityServiceImpl implements RecipeEntityService {

    @Override
    public Recipe create(RecipeForm recipeForm) {
        return null;
    }

    @Override
    public Recipe findById(String id) {
        return null;
    }

    @Override
    public List<Recipe> findAll() {
        return null;
    }

    @Override
    public Recipe update(String id, RecipeForm recipeForm) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
