package com.example.recipeDatabase.service.facade.implementations;

import com.example.recipeDatabase.model.dto.form.RecipeIngredientForm;
import com.example.recipeDatabase.model.dto.view.RecipeIngredientDTO;
import com.example.recipeDatabase.service.facade.interfaces.DTOService;
import com.example.recipeDatabase.service.facade.interfaces.RecipeIngredientService;
import com.example.recipeDatabase.service.interfaces.RecipeIngredientEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RecipeIngredientServiceImpl implements RecipeIngredientService {

    private final RecipeIngredientEntityService recipeIngredientEntityService;
    private final DTOService dtoConverter;

    @Autowired
    public RecipeIngredientServiceImpl(RecipeIngredientEntityService recipeIngredientEntityService, DTOService dtoConverter) {
        this.recipeIngredientEntityService = recipeIngredientEntityService;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public RecipeIngredientDTO create(RecipeIngredientForm recipeIngredientForm) {
        return dtoConverter.toFullRecipeIngredientDTO(recipeIngredientEntityService.create(recipeIngredientForm));
    }

    @Override
    public RecipeIngredientDTO findById(String id) {
        return dtoConverter.toFullRecipeIngredientDTO(recipeIngredientEntityService.findById(id));
    }

    @Override
    public List<RecipeIngredientDTO> findAll() {
        return recipeIngredientEntityService.findAll().stream()
                .map(dtoConverter::toFullRecipeIngredientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeIngredientDTO update(String id, RecipeIngredientForm recipeIngredientForm) {
        return dtoConverter.toFullRecipeIngredientDTO(recipeIngredientEntityService.update(id, recipeIngredientForm));
    }

    @Override
    public void delete(String id) {
        recipeIngredientEntityService.delete(id);
    }
}
