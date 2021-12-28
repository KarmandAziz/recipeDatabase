package com.example.recipeDatabase.validation.message;

public class ValidationMessages {
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    public static final String WEAK_PASSWORD = "Password is too weak. Minimum 8 characters with at least one number";
    public static final String MANDATORY_FIELD = "This field is mandatory";
    public static final String USERNAME_SIZE = "Must be between 6 and 100 chars";
    public static final String USERNAME_TAKEN = "This username is already taken";
    public static final String MANDATORY_FORM = "This field is mandatory";
    public static final String UNIQUE_EMAIL = "This email is already taken";
}
