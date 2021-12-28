package com.example.recipeDatabase.database.daointerface;

import com.example.recipeDatabase.model.entity.AppUser;
import com.example.recipeDatabase.model.entity.UserRole;

import java.util.List;
import java.util.Optional;

public interface AppUserDAO extends DAOGenericCRUD <AppUser, String>{
    Optional<AppUser> findByUsername(String username);
    List<AppUser> findByUserRole(UserRole role);
}
