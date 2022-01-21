package com.example.recipeDatabase.service.implementations;

import com.example.recipeDatabase.data.RecipeCategoryDAO;
import com.example.recipeDatabase.data.RecipeDAO;
import com.example.recipeDatabase.data.RecipeIngredientDAO;
import com.example.recipeDatabase.exception.AppResourceNotFoundException;
import com.example.recipeDatabase.model.dto.form.RecipeForm;
import com.example.recipeDatabase.model.dto.form.RecipeInstructionForm;
import com.example.recipeDatabase.model.entity.Recipe;
import com.example.recipeDatabase.model.entity.RecipeCategory;
import com.example.recipeDatabase.service.interfaces.RecipeCategoryEntityService;
import com.example.recipeDatabase.service.interfaces.RecipeEntityService;
import com.example.recipeDatabase.service.interfaces.RecipeInstructionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class RecipeEntityServiceImpl implements RecipeEntityService {

    private final RecipeDAO recipeDAO;
    private final RecipeInstructionEntityService recipeInstructionEntityService;
    private final RecipeCategoryDAO recipecategoryDAO;


    public RecipeEntityServiceImpl(RecipeDAO recipeDAO, RecipeInstructionEntityService recipeInstructionEntityService, RecipeCategoryDAO recipecategoryDAO) {
        this.recipeDAO = recipeDAO;
        this.recipeInstructionEntityService = recipeInstructionEntityService;
        this.recipecategoryDAO = recipecategoryDAO;
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


    @Override
    public Recipe addRecipeCategory(String id, String categoryId) {
        Recipe recipe = findById(id);
        RecipeCategory recipeCategory = recipecategoryDAO.findById(categoryId)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find Category with id " + categoryId));
        recipe.addRecipeCategory(recipeCategory);

        recipe = recipeDAO.save(recipe);
        return recipe;
    }

    @Override
    public Recipe removeRecipeCategory(String id, String categoryId) {
        Recipe recipe = findById(id);
        RecipeCategory recipeCategory = recipecategoryDAO.findById(categoryId)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find Category with id " + categoryId));
        recipe.removeRecipeCategory(recipeCategory);

        recipe = recipeDAO.save(recipe);
        return recipe;
    }

    @Override
    public List<Recipe> findByRecipeNameContaining(String recipeName) {
        return recipeDAO.findByRecipeNameContaining(recipeName);
    }

    @Override
    public Recipe searchByRecipeName(String name) {
        return recipeDAO.searchByRecipeName(name)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find recipe"));
    }

    @Override
    public List<Recipe> searchByCategory(String category) {
        return recipeDAO.searchByCategory(category);
    }

    @Override
    public List<Recipe> searchByAnyCategories(String... categories) {
        return recipeDAO.searchByAnyCategories(categories);
    }
}
