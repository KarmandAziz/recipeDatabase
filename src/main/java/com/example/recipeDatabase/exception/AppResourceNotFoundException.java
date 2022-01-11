package com.example.recipeDatabase.exception;

public class AppResourceNotFoundException extends RuntimeException{
    public AppResourceNotFoundException(String message){
        super(message);
    }
}
