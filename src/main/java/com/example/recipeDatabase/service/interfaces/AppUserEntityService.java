package com.example.recipeDatabase.service.interfaces;

import com.example.recipeDatabase.model.dto.form.AppUserForm;
import com.example.recipeDatabase.model.entity.AppUser;
import com.example.recipeDatabase.model.entity.UserRole;

import java.util.List;

public interface AppUserEntityService extends GenericEntityService<AppUser, AppUserForm>{

    AppUser findByUsername(String username);
    List<AppUser> findByUserRole(UserRole role);
    AppUser create(AppUserForm form, UserRole role);
    AppUser addRole(String id, UserRole role);
    AppUser removeRole(String id, UserRole role);

}
