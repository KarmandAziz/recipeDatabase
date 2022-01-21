package com.example.recipeDatabase.controller;

import com.mashape.unirest.http.Unirest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@RestController
public class ExternalAPIController {

    @GetMapping(value = "api/v1/recipes/allRecipes")
    public List<Object> getRecipes(){
        String url = "http://www7.slv.se/apilivsmedel/LivsmedelService.svc/Livsmedel/Naringsvarde/<ÅÅÅÅMMDD>";
        RestTemplate restTemplate = new RestTemplate();
        Object[] recipes = restTemplate.getForObject(url, Object[].class);

        return Arrays.asList(recipes);
    }

}
