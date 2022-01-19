package com.example.recipeDatabase.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public class AppUserDetails implements UserDetails, Serializable {

    private String userId;
    private String username;
    private String recipeId;
    private String recipeCategoryId;
    private String recipeInstructionId;
    private String recipeIngredientId;
    private String IngredientId;
    private String password;
    private boolean active;
    private Set<SimpleGrantedAuthority> authorities;


    public AppUserDetails(String userId,
                          boolean active,
                          String username,
                          String recipeId,
                          String recipeCategoryId,
                          String recipeInstructionId,
                          String recipeIngredientId,
                          String ingredientId,
                          String password,
                          Set<SimpleGrantedAuthority> authorities) {
        this.userId = userId;
        this.username = username;
        this.recipeId = recipeId;
        this.recipeCategoryId = recipeCategoryId;
        this.recipeInstructionId = recipeInstructionId;
        this.recipeIngredientId = recipeIngredientId;
        IngredientId = ingredientId;
        this.password = password;
        this.authorities = authorities;
        this.active = active;
    }

    public AppUserDetails() {
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public void setRecipeCategoryId(String recipeCategoryId) {
        this.recipeCategoryId = recipeCategoryId;
    }

    public String getRecipeInstructionId() {
        return recipeInstructionId;
    }

    public void setRecipeInstructionId(String recipeInstructionId) {
        this.recipeInstructionId = recipeInstructionId;
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(String recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public String getIngredientId() {
        return IngredientId;
    }

    public void setIngredientId(String ingredientId) {
        IngredientId = ingredientId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Set<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
