package com.example.recipeDatabase.controller;

import com.example.recipeDatabase.model.dto.form.RecipeForm;
import com.example.recipeDatabase.model.dto.view.RecipeDTO;
import com.example.recipeDatabase.service.facade.interfaces.RecipeService;
import com.example.recipeDatabase.validation.OnPost;
import com.example.recipeDatabase.validation.OnPut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @PostMapping("/api/v1/recipes")
    public ResponseEntity<RecipeDTO> createRecipe(@Validated(OnPost.class) @RequestBody RecipeForm form){
        return ResponseEntity.status(201).body(
                recipeService.create(form)
        );
    }

    @GetMapping("/api/v1/recipes")
    public ResponseEntity<List<RecipeDTO>> find(
            @RequestParam(value = "search", defaultValue = "all") String search,
            @RequestParam(value = "value", required = false ) List<String> values
    ){
        List<RecipeDTO> recipeDTOS;
        switch (search.toLowerCase()){
            case "recipeName":
                recipeDTOS = recipeService.searchByRecipeName(values.get(0));
                break;
            case "recipeNameContaining":
                recipeDTOS = recipeService.findByRecipeNameContaining(values.get(0));
                break;
            case "category":
                recipeDTOS = recipeService.searchByCategory(values.get(0));
                break;
            case "categories":
                recipeDTOS = recipeService.searchByAnyCategories(values.get(0));
                break;
            case "all":
                recipeDTOS = recipeService.findAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid search value: " + search +
                        ". Valid search values are 'all', 'recipeName', 'recipeNameContaining', 'category', 'categories''");
        }

        return ResponseEntity.ok(recipeDTOS);
    }

    @GetMapping("/api/v1/recipes/{id}")
    public ResponseEntity<RecipeDTO> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(recipeService.findById(id));
    }


    @PutMapping("/api/v1/recipes/{id}")
    public ResponseEntity<RecipeDTO> update(@PathVariable("id") String id, @Validated(OnPut.class) @RequestBody RecipeForm recipeForm){
        return ResponseEntity.ok(recipeService.update(id, recipeForm));
    }


    @DeleteMapping("/api/v1/bookings/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        recipeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
