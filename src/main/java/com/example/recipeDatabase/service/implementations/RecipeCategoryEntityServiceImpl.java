package com.example.recipeDatabase.service.implementations;


import com.example.recipeDatabase.data.RecipeCategoryDAO;
import com.example.recipeDatabase.exception.AppResourceNotFoundException;
import com.example.recipeDatabase.model.dto.form.RecipeCategoryForm;
import com.example.recipeDatabase.model.entity.RecipeCategory;
import com.example.recipeDatabase.service.interfaces.RecipeCategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RecipeCategoryEntityServiceImpl implements RecipeCategoryEntityService {

    private final RecipeCategoryDAO recipeCategoryDAO;

    @Autowired
    public RecipeCategoryEntityServiceImpl(RecipeCategoryDAO recipeCategoryDAO) {
        this.recipeCategoryDAO = recipeCategoryDAO;
    }

    @Override
    public RecipeCategory create(RecipeCategoryForm recipeCategoryForm) {
        if(recipeCategoryForm == null) throw new IllegalArgumentException("RecipeCategoryForm was null");
        RecipeCategory recipeCategory = new RecipeCategory();
        recipeCategory.setCategory(recipeCategoryForm.getCategory());


        return recipeCategoryDAO.save(recipeCategory);
    }

    @Override
    public RecipeCategory findById(String id) {
        return recipeCategoryDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find recipeCategory with id " +id));
    }

    @Override
    public List<RecipeCategory> findAll() {
        return recipeCategoryDAO.findAll();
    }

    @Override
    public RecipeCategory update(String id, RecipeCategoryForm recipeCategoryForm) {
        RecipeCategory recipeCategory = findById(id);

        recipeCategory.setCategory(recipeCategory.getCategory());

        return recipeCategoryDAO.save(recipeCategory);

    }

    @Override
    public void delete(String id) {
       RecipeCategory recipeCategory = findById(id);
       recipeCategory.setRecipes(null);
       recipeCategory.setCategory(null);

       recipeCategoryDAO.delete(recipeCategory);
    }
}
