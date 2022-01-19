package com.example.recipeDatabase.controller;

import com.example.recipeDatabase.model.entity.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UtilityController {

    @GetMapping("/api/v1/utilities/roles")
    public ResponseEntity<UserRole[]> getRoles(){
        return ResponseEntity.ok(UserRole.values());
    }

    @GetMapping("/api/v1/utilities/params")
    public ResponseEntity<?> getValidRequestParams(){
        Map<String, List<String>> map = new HashMap<>();
        map.put("users:search", new ArrayList<>(Arrays.asList("role", "username", "all")));
        map.put("recipe:search", new ArrayList<>(Arrays.asList("all", "recipeName", "recipeNameContaining", "category", "categories")));
        return ResponseEntity.ok(map);
    }
}
