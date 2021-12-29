package com.example.recipeDatabase.model.dto.form;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import static com.example.recipeDatabase.validation.message.ValidationMessages.MANDATORY_FIELD;

@Validated
public class IngredientForm implements Serializable {

    private String id;
    @NotBlank(message = MANDATORY_FIELD)
    private String ingredientName;



}
