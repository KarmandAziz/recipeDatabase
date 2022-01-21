package com.example.recipeDatabase.service.facade.implementations;

import com.example.recipeDatabase.data.RecipeCategoryDAO;
import com.example.recipeDatabase.data.RecipeDAO;
import com.example.recipeDatabase.model.dto.form.RecipeForm;
import com.example.recipeDatabase.model.dto.view.RecipeDTO;
import com.example.recipeDatabase.service.facade.interfaces.DTOService;
import com.example.recipeDatabase.service.facade.interfaces.RecipeService;
import com.example.recipeDatabase.service.interfaces.RecipeCategoryEntityService;
import com.example.recipeDatabase.service.interfaces.RecipeEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

    private final RecipeEntityService recipeEntityService;
    private final DTOService dtoConverter;

    @Autowired
    public RecipeServiceImpl(RecipeEntityService recipeEntityService, DTOService dtoConverter) {
        this.recipeEntityService = recipeEntityService;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public RecipeDTO addRecipeCategory(String id, String categoryId) {
        return dtoConverter.toFullRecipeDTO(recipeEntityService.addRecipeCategory(id, categoryId));
    }

    @Override
    public RecipeDTO removeRecipeCategory(String id, String categoryId) {
        return dtoConverter.toFullRecipeDTO(recipeEntityService.removeRecipeCategory(id, categoryId));
    }

    @Override
    public List<RecipeDTO> findByRecipeNameContaining(String recipeName) {
        return recipeEntityService.findByRecipeNameContaining(recipeName).stream()
                .map(dtoConverter::toSmallRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO searchByRecipeName(String name) {
        return dtoConverter.toSmallRecipeDTO(recipeEntityService.searchByRecipeName(name));
    }

    @Override
    public List<RecipeDTO> searchByCategory(String category) {
        return recipeEntityService.searchByCategory(category).stream()
                .map(dtoConverter::toFullRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RecipeDTO> searchByAnyCategories(String... categories) {
        return recipeEntityService.searchByAnyCategories(categories).stream()
                .map(dtoConverter::toFullRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO create(RecipeForm recipeForm) {
        return dtoConverter.toFullRecipeDTO(recipeEntityService.create(recipeForm));
    }

    @Override
    public RecipeDTO findById(String id) {
        return dtoConverter.toFullRecipeDTO(recipeEntityService.findById(id));
    }

    @Override
    public List<RecipeDTO> findAll() {
        return recipeEntityService.findAll().stream()
                .map(dtoConverter::toFullRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO update(String id, RecipeForm recipeForm) {
        return dtoConverter.toFullRecipeDTO(recipeEntityService.update(id, recipeForm));
    }

    @Override
    public void delete(String id) {
        recipeEntityService.delete(id);

    }
}
