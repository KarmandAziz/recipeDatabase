package com.example.recipeDatabase.service.facade.implementations;

import com.example.recipeDatabase.model.dto.form.IngredientForm;
import com.example.recipeDatabase.model.dto.form.RecipeIngredientForm;
import com.example.recipeDatabase.model.dto.view.IngredientDTO;
import com.example.recipeDatabase.model.entity.Ingredient;
import com.example.recipeDatabase.service.facade.interfaces.DTOService;
import com.example.recipeDatabase.service.facade.interfaces.IngredientService;
import com.example.recipeDatabase.service.interfaces.IngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {

    private final IngredientEntityService ingredientEntityService;
    private final DTOService dtoConverter;

    @Autowired
    public IngredientServiceImpl(IngredientEntityService ingredientEntityService, DTOService dtoConverter) {
        this.ingredientEntityService = ingredientEntityService;
        this.dtoConverter = dtoConverter;
    }


    @Override
    public IngredientDTO addNewRecipeIngredient(String ingredientId, String recipeIngredientId) {
        Ingredient ingredient = ingredientEntityService.addNewRecipeIngredient(ingredientId, recipeIngredientId);
        return dtoConverter.toIngredientDTO(ingredient);
    }

    @Override
    public IngredientDTO removeRecipeIngredient(String ingredientId, String recipeIngredientId) {
        Ingredient ingredient = ingredientEntityService.removeRecipeIngredient(ingredientId, recipeIngredientId);
        return dtoConverter.toIngredientDTO(ingredient);
    }

    @Override
    public IngredientDTO moveRecipeIngredient(String ingredientId, String recipeIngredientId) {
        Ingredient ingredient = ingredientEntityService.moveRecipeIngredient(ingredientId, recipeIngredientId);
        return dtoConverter.toIngredientDTO(ingredient);
    }


    @Override
    public IngredientDTO create(IngredientForm ingredientForm) {
        Ingredient ingredient = ingredientEntityService.create(ingredientForm);
        return dtoConverter.toIngredientDTO(ingredient);
    }

    @Override
    public IngredientDTO findById(String id) {
        Ingredient ingredient = ingredientEntityService.findById(id);
        return dtoConverter.toIngredientDTO(ingredient);
    }

    @Override
    public List<IngredientDTO> findAll() {
        return ingredientEntityService.findAll().stream()
                .map(dtoConverter::toIngredientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientDTO update(String id, IngredientForm ingredientForm) {
        Ingredient ingredient = ingredientEntityService.update(id, ingredientForm);
        return dtoConverter.toIngredientDTO(ingredient);
    }

    @Override
    public void delete(String id) {
        ingredientEntityService.delete(id);
    }
}
