package com.example.recipeDatabase.database.daointerface;

import com.example.recipeDatabase.model.entity.AppRole;
import com.example.recipeDatabase.model.entity.UserRole;

import java.util.Optional;

public interface AppRoleDAO extends DAOGenericCRUD <AppRole, String>{
    Optional<AppRole> findByUserRole(UserRole userRole);

}
