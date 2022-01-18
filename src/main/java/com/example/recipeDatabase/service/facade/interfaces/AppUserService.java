package com.example.recipeDatabase.service.facade.interfaces;

import com.example.recipeDatabase.model.dto.form.AppUserForm;
import com.example.recipeDatabase.model.dto.view.AppUserDTO;
import com.example.recipeDatabase.model.entity.UserRole;

import java.util.List;

public interface AppUserService {

    AppUserDTO create(AppUserForm form, UserRole role);
    AppUserDTO findById(String id);
    AppUserDTO findByUsername(String username);
    AppUserDTO addRole(String id, UserRole role);
    AppUserDTO removeRole(String id, UserRole role);
    List<AppUserDTO> findAll();
    List<AppUserDTO> findByUserRole(UserRole role);
    AppUserDTO update(String id, AppUserForm form);
    void delete(String id);
}
