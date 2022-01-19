package com.example.recipeDatabase.service.facade.implementations;

import com.example.recipeDatabase.model.dto.form.RecipeInstructionForm;
import com.example.recipeDatabase.model.dto.view.RecipeInstructionDTO;
import com.example.recipeDatabase.model.entity.RecipeInstruction;
import com.example.recipeDatabase.service.facade.interfaces.DTOService;
import com.example.recipeDatabase.service.facade.interfaces.RecipeInstructionService;
import com.example.recipeDatabase.service.interfaces.RecipeInstructionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class RecipeInstructionServiceImpl implements RecipeInstructionService {

    private final RecipeInstructionEntityService recipeInstructionEntityService;
    private final DTOService dtoConverter;

    @Autowired
    public RecipeInstructionServiceImpl(RecipeInstructionEntityService recipeInstructionEntityService, DTOService dtoConverter) {
        this.recipeInstructionEntityService = recipeInstructionEntityService;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public RecipeInstructionDTO create(RecipeInstructionForm recipeInstructionForm) {
        RecipeInstruction recipeInstruction = recipeInstructionEntityService.create(recipeInstructionForm);
        return dtoConverter.toRecipeInstructionDTO(recipeInstruction);
    }

    @Override
    public RecipeInstructionDTO findById(String id) {
        RecipeInstruction recipeInstruction = recipeInstructionEntityService.findById(id);
        return dtoConverter.toRecipeInstructionDTO(recipeInstruction);
    }

    @Override
    public List<RecipeInstructionDTO> findAll() {
        return recipeInstructionEntityService.findAll().stream()
                .map(dtoConverter::toRecipeInstructionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeInstructionDTO update(String id, RecipeInstructionForm recipeInstructionForm) {
        RecipeInstruction recipeInstruction = recipeInstructionEntityService.update(id, recipeInstructionForm);
        return dtoConverter.toRecipeInstructionDTO(recipeInstruction);
    }

    @Override
    public void delete(String id) {
        recipeInstructionEntityService.delete(id);
    }
}
