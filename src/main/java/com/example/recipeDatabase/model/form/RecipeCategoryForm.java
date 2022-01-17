package com.example.recipeDatabase.model.form;

import com.example.recipeDatabase.validation.OnPut;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

import static com.example.recipeDatabase.validation.message.ValidationMessages.MANDATORY_FIELD;

@Validated
public class RecipeCategoryForm implements Serializable{

    private String id;
    @NotBlank(message = MANDATORY_FIELD)
    private String category;

    public RecipeCategoryForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
