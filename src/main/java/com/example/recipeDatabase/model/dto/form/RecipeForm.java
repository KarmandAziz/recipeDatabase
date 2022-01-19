package com.example.recipeDatabase.model.dto.form;

import com.example.recipeDatabase.model.entity.RecipeCategory;
import com.example.recipeDatabase.model.entity.RecipeIngredient;
import com.example.recipeDatabase.model.entity.RecipeInstruction;
import com.example.recipeDatabase.validation.OnPost;
import com.example.recipeDatabase.validation.OnPut;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import static com.example.recipeDatabase.validation.message.ValidationMessages.MANDATORY_FIELD;
@Validated
public class RecipeForm implements Serializable {

    @NotBlank(message = MANDATORY_FIELD,groups = OnPost.class)
    private String id;
    @NotBlank(message = MANDATORY_FIELD,groups = {OnPost.class, OnPut.class})
    private String recipeName;
    @NotNull(message = MANDATORY_FIELD,groups = {OnPost.class,OnPut.class})
    @Valid private RecipeInstructionForm recipeInstruction;


    public RecipeForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public RecipeInstructionForm getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstructionForm recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }
}
