package com.example.recipeDatabase.controller;

import com.example.recipeDatabase.model.dto.form.RecipeCategoryForm;
import com.example.recipeDatabase.model.dto.view.RecipeCategoryDTO;
import com.example.recipeDatabase.service.facade.interfaces.RecipeCategoryService;
import com.example.recipeDatabase.validation.OnPost;
import com.example.recipeDatabase.validation.OnPut;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeCategoryController {

    private final RecipeCategoryService recipeCategoryService;

    @Autowired
    public RecipeCategoryController(RecipeCategoryService recipeCategoryService) {
        this.recipeCategoryService = recipeCategoryService;
    }
    @Secured({"ROLE_SUPER_ADMIN","ROLE_CASUAL_ADMIN"})
    @PostMapping("/api/v1/recipe/category")
    public ResponseEntity<RecipeCategoryDTO> create(@Validated(OnPost.class) @RequestBody RecipeCategoryForm recipeCategoryForm){
        return ResponseEntity.status(201).body(recipeCategoryService.create(recipeCategoryForm));
    }

    @Secured({"ROLE_SUPER_ADMIN","ROLE_CASUAL_ADMIN"})
    @GetMapping("/api/v1/categories")
    public ResponseEntity<List<RecipeCategoryDTO>> find(){
        return ResponseEntity.ok(recipeCategoryService.findAll());
    }

    @Secured({"ROLE_SUPER_ADMIN","ROLE_CASUAL_ADMIN"})
    @GetMapping("/api/v1/category/{id}")
    public ResponseEntity<RecipeCategoryDTO> findById(@PathVariable("id") String id){
        return ResponseEntity.ok(recipeCategoryService.findById(id));
    }

    @PreAuthorize("#id == authentication.principal.categoryId || hasAnyRole('SUPER_ADMIN')")
    @PutMapping("/api/v1/category/{id}")
    public ResponseEntity<RecipeCategoryDTO> update(@PathVariable("id") String id, @Validated(OnPut.class) @RequestBody RecipeCategoryForm recipeCategoryForm){
        return ResponseEntity.ok(recipeCategoryService.update(id, recipeCategoryForm));
    }

    @Secured({"ROLE_SUPER_ADMIN"})
    @DeleteMapping("/api/v1/category/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        recipeCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
