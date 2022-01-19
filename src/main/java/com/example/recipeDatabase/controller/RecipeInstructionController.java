package com.example.recipeDatabase.controller;

import com.example.recipeDatabase.model.dto.form.RecipeInstructionForm;
import com.example.recipeDatabase.model.dto.view.RecipeInstructionDTO;
import com.example.recipeDatabase.service.facade.interfaces.RecipeInstructionService;
import com.example.recipeDatabase.validation.OnPost;
import com.example.recipeDatabase.validation.OnPut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeInstructionController {

    private final RecipeInstructionService recipeInstructionService;

    @Autowired
    public RecipeInstructionController(RecipeInstructionService recipeInstructionService) {
        this.recipeInstructionService = recipeInstructionService;
    }
    @Secured({"ROLE_SUPER_ADMIN","ROLE_CASUAL_ADMIN"})
    @PostMapping("/api/v1/instructions")
    public ResponseEntity<RecipeInstructionDTO> create(@Validated(OnPost.class) @RequestBody RecipeInstructionForm recipeInstructionForm) {
        RecipeInstructionDTO instructions = recipeInstructionService.create(recipeInstructionForm);
        return ResponseEntity.status(201).body(instructions);
    }

    @GetMapping("/api/v1/instructions")
    public ResponseEntity<List<RecipeInstructionDTO>> find() {
        return ResponseEntity.ok(
                recipeInstructionService.findAll()
        );
    }

    @GetMapping("/api/v1/instructions/{id}")
    public ResponseEntity<RecipeInstructionDTO> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(recipeInstructionService.findById(id));
    }

    @PutMapping("/api/v1/instructions/{id}")
    public ResponseEntity<RecipeInstructionDTO> update(@PathVariable("id") String id, @Validated(OnPut.class) @RequestBody RecipeInstructionForm form) {
        return ResponseEntity.ok(recipeInstructionService.update(id, form));
    }
    @Secured({"ROLE_SUPER_ADMIN","ROLE_CASUAL_ADMIN"})
    @DeleteMapping("/api/v1/instructions/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        recipeInstructionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
