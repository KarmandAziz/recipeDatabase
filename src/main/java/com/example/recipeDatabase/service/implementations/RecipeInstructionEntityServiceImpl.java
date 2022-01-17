package com.example.recipeDatabase.service.implementations;

import com.example.recipeDatabase.data.RecipeInstructionDAO;
import com.example.recipeDatabase.exception.AppResourceNotFoundException;
import com.example.recipeDatabase.model.dto.form.RecipeInstructionForm;
import com.example.recipeDatabase.model.entity.RecipeInstruction;
import com.example.recipeDatabase.service.interfaces.RecipeInstructionEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

;
import java.util.List;

@Service
@Transactional
public class RecipeInstructionEntityServiceImpl implements RecipeInstructionEntityService {

    private final RecipeInstructionDAO recipeInstructionDAO;

    @Autowired
    public RecipeInstructionEntityServiceImpl(RecipeInstructionDAO recipeInstructionDAO) {
        this.recipeInstructionDAO = recipeInstructionDAO;
    }


    @Override
    public RecipeInstruction create(RecipeInstructionForm recipeInstructionForm) {
        if(recipeInstructionForm == null){
            throw new IllegalArgumentException("RecipeInstructionForm was null");
        }
        RecipeInstruction recipeInstruction = new RecipeInstruction();
        recipeInstruction.setInstructions(recipeInstructionForm.getInstructions());

        return recipeInstructionDAO.save(recipeInstruction);
    }

    @Override
    public RecipeInstruction findById(String id) {
        return recipeInstructionDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find RecipeInstruction with id " + id));
    }

    @Override
    public List<RecipeInstruction> findAll() {
        return recipeInstructionDAO.findAll();
    }

    @Override
    public RecipeInstruction update(String id, RecipeInstructionForm recipeInstructionForm) {
        RecipeInstruction recipeInstruction = findById(id);

        recipeInstruction.setInstructions(recipeInstructionForm.getInstructions());

        return recipeInstructionDAO.save(recipeInstruction);
    }

    @Override
    public void delete(String id) {
        RecipeInstruction recipeInstruction = findById(id);

        recipeInstructionDAO.delete(recipeInstruction);

    }
}
