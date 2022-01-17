package com.example.recipeDatabase.service.implementations;

import com.example.recipeDatabase.data.RecipeDAO;
import com.example.recipeDatabase.exception.AppResourceNotFoundException;
import com.example.recipeDatabase.model.dto.form.RecipeForm;
import com.example.recipeDatabase.model.dto.form.RecipeInstructionForm;
import com.example.recipeDatabase.model.entity.Recipe;
import com.example.recipeDatabase.service.interfaces.RecipeEntityService;
import com.example.recipeDatabase.service.interfaces.RecipeInstructionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RecipeEntityServiceImpl implements RecipeEntityService {

    private final RecipeDAO recipeDAO;
    private final RecipeInstructionEntityService recipeInstructionEntityService;

    @Autowired
    public RecipeEntityServiceImpl(RecipeDAO recipeDAO, RecipeInstructionEntityService recipeInstructionEntityService) {
        this.recipeDAO = recipeDAO;
        this.recipeInstructionEntityService = recipeInstructionEntityService;
    }


    @Override
    public Recipe create(RecipeForm recipeForm) {
        if(recipeForm == null){
            throw new IllegalArgumentException("RecipeForm was null.");
        }
        Recipe recipe = new Recipe();
        recipe.setRecipeName(recipeForm.getRecipeName());
        recipe.setInstruction(recipeInstructionEntityService.create(
                recipeForm.getRecipeInstruction()));
        return recipeDAO.save(recipe);
    }

    @Override
    public Recipe findById(String id) {
        return recipeDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find Recipe with id " +id));
    }

    @Override
    public List<Recipe> findAll() {
        return recipeDAO.findAll();
    }

    @Override
    public Recipe update(String id, RecipeForm recipeForm) {
        Recipe recipe = findById(id);
        recipe.setRecipeName(recipeForm.getRecipeName());
        recipe.setInstruction(recipeInstructionEntityService.create(recipeForm.getRecipeInstruction()));
        return recipeDAO.save(recipe);
    }


    @Override
    public void delete(String id) {
        Recipe recipe = findById(id);
        recipe.setRecipeIngredients(null);
        recipe.setCategories(null);
        recipe.setInstruction(null);
        recipeDAO.deleteById(id);

    }



}
