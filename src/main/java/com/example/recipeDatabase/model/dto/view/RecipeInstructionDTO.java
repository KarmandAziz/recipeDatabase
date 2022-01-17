package com.example.recipeDatabase.model.dto.view;

import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
@Validated
public class RecipeInstructionDTO implements Serializable {

    private String id;
    private String instructions;

    public RecipeInstructionDTO(String id, String instructions) {
        this.id = id;
        this.instructions = instructions;
    }

    public RecipeInstructionDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
