package com.example.recipeDatabase.service.facade.implementations;

import com.example.recipeDatabase.model.dto.form.RecipeCategoryForm;
import com.example.recipeDatabase.model.dto.view.RecipeCategoryDTO;
import com.example.recipeDatabase.model.entity.RecipeCategory;
import com.example.recipeDatabase.service.facade.interfaces.DTOService;
import com.example.recipeDatabase.service.facade.interfaces.RecipeCategoryService;
import com.example.recipeDatabase.service.interfaces.RecipeCategoryEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeCategoryServiceImpl implements RecipeCategoryService {

    private final RecipeCategoryEntityService recipeCategoryEntityService;
    private final DTOService dtoConverter;

    @Autowired
    public RecipeCategoryServiceImpl(RecipeCategoryEntityService recipeCategoryEntityService, DTOService dtoConverter) {
        this.recipeCategoryEntityService = recipeCategoryEntityService;
        this.dtoConverter = dtoConverter;
    }



    @Override
    public RecipeCategoryDTO create(RecipeCategoryForm recipeCategoryForm) {
        RecipeCategory recipeCategory = recipeCategoryEntityService.create(recipeCategoryForm);
        return dtoConverter.toFullRecipeCategoryDTO(recipeCategory);
    }

    @Override
    public RecipeCategoryDTO findById(String id) {
        RecipeCategory recipeCategory = recipeCategoryEntityService.findById(id);
        return dtoConverter.toFullRecipeCategoryDTO(recipeCategory);
    }

    @Override
    public List<RecipeCategoryDTO> findAll() {
        return recipeCategoryEntityService.findAll().stream()
                .map(dtoConverter::toSmallRecipeCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeCategoryDTO update(String id, RecipeCategoryForm recipeCategoryForm) {
        RecipeCategory recipeCategory = recipeCategoryEntityService.update(id, recipeCategoryForm);
        return dtoConverter.toFullRecipeCategoryDTO(recipeCategory);
    }

    @Override
    public void delete(String id) {
        recipeCategoryEntityService.delete(id);

    }
}
