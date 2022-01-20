package com.example.recipeDatabase.controller;

import com.example.recipeDatabase.model.dto.form.IngredientForm;
import com.example.recipeDatabase.model.dto.view.IngredientDTO;
import com.example.recipeDatabase.model.entity.Ingredient;
import com.example.recipeDatabase.service.facade.interfaces.IngredientService;
import com.example.recipeDatabase.validation.OnPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IngredientController {

    private final IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }


    @GetMapping("/api/v1/ingredients")
    public ResponseEntity<List<IngredientDTO>> getAll() {
        List<IngredientDTO> ingredients = ingredientService.findAll();
        return ResponseEntity.ok().body(ingredients);
    }

    @PutMapping("/api/v1/ingredient/{id}/recipeIngredient/add")
    public ResponseEntity<IngredientDTO> addNewRecipeIngredient(@PathVariable("id") String id, @RequestParam(name = "recipeIngredientId") String recipeIngredientId){
        return ResponseEntity.ok(ingredientService.addNewRecipeIngredient(id, recipeIngredientId));
    }


    @PutMapping("/api/v1/ingredient/{id}/recipeIngredient/remove")
    public ResponseEntity<IngredientDTO> removeRecipeIngredient(@PathVariable("id") String id, @RequestParam(name = "recipeIngredientId") String recipeIngredientId){
        return ResponseEntity.ok(ingredientService.removeRecipeIngredient(id, recipeIngredientId));
    }


    @PutMapping("/api/v1/ingredient/{id}/recipeIngredient")
    public ResponseEntity<IngredientDTO> moveRecipeIngredient(@PathVariable("id") String id, @RequestParam(name = "recipeIngredientId") String recipeIngredientId){
        return ResponseEntity.ok(ingredientService.removeRecipeIngredient(id, recipeIngredientId));
    }


    @DeleteMapping("/api/v1/recipe/ingredient/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        ingredientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/v1/recipe/ingredient")
    public ResponseEntity<IngredientDTO> create(@Validated(OnPost.class) @RequestBody IngredientForm form){
        return ResponseEntity.status(201).body(ingredientService.create(form));
    }

}
