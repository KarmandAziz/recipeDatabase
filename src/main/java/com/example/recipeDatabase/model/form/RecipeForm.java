package com.example.recipeDatabase.model.form;

import com.example.recipeDatabase.validation.OnPost;
import com.example.recipeDatabase.validation.OnPut;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

import static com.example.recipeDatabase.validation.message.ValidationMessages.MANDATORY_FIELD;
@Validated
public class RecipeForm implements Serializable {

    @NotBlank(message = MANDATORY_FIELD,groups = OnPost.class)
    private String id;
    @NotBlank(message = MANDATORY_FIELD,groups = {OnPost.class, OnPut.class})
    private String recipeName;

    @NotNull(message = MANDATORY_FIELD,groups = {OnPost.class,OnPut.class})
    @Valid
    private RecipeInstructionForm recipeInstruction;

    @NotBlank(message = MANDATORY_FIELD,groups = {OnPost.class,OnPut.class})
    private List<Integer> recipeCategoryId;

    @NotBlank(message = MANDATORY_FIELD)
    private List<String> recipeIngredientId;

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

    public List<Integer> getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public void setRecipeCategoryId(List<Integer> recipeCategoryId) {
        this.recipeCategoryId = recipeCategoryId;
    }

    public List<String> getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(List<String> recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }
}
