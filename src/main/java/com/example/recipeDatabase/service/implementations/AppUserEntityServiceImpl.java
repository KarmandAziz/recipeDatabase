package com.example.recipeDatabase.service.implementations;

import com.example.recipeDatabase.data.AppRoleDAO;
import com.example.recipeDatabase.data.AppUserDAO;
import com.example.recipeDatabase.exception.AppResourceNotFoundException;
import com.example.recipeDatabase.model.dto.form.AppUserForm;
import com.example.recipeDatabase.model.entity.AppRole;
import com.example.recipeDatabase.model.entity.AppUser;
import com.example.recipeDatabase.model.entity.UserRole;
import com.example.recipeDatabase.service.interfaces.AppUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppUserEntityServiceImpl implements AppUserEntityService {

    private final AppUserDAO appUserDAO;
    private final AppRoleDAO appRoleDAO;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AppUserEntityServiceImpl(AppUserDAO appUserDAO, AppRoleDAO appRoleDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserDAO = appUserDAO;
        this.appRoleDAO = appRoleDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public AppUser findByUsername(String username) {
        return appUserDAO.findByUsername(username)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find user with provided username"));
    }

    @Override
    public List<AppUser> findByUserRole(UserRole role) {
        return appUserDAO.findByUserRole(role);
    }

    @Override
    public AppUser create(AppUserForm appUserForm, UserRole role) {
        if(appUserForm == null){
            throw new IllegalArgumentException("AppUserForm was null");
        }
        AppUser appUser = new AppUser();
        appUser.setUsername(appUserForm.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUserForm.getPassword()));
        AppRole appRole = appRoleDAO.findByUserRole(role)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find AppRole"));
        appUser.addAppRole(appRole);

        return appUserDAO.save(appUser);
    }

    @Override
    public AppUser addRole(String id, UserRole role) {
        AppUser appUser = findById(id);
        AppRole appRole = appRoleDAO.findByUserRole(role)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find role"));
        appUser.addAppRole(appRole);

        return appUserDAO.save(appUser);
    }


    @Override
    public AppUser removeRole(String id, UserRole role) {
        AppUser appUser = findById(id);
        AppRole appRole = appRoleDAO.findByUserRole(role)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find role"));
        appUser.removeAppRole(appRole);

        return appUserDAO.save(appUser);
    }

    @Override
    public AppUser create(AppUserForm appUserForm) {
        if(appUserForm == null){
            throw new IllegalArgumentException("AppUserForm was null");
        }
        return create(appUserForm, UserRole.ROLE_USER_CASUAL);
    }

    @Override
    public AppUser findById(String id) {
        return appUserDAO.findById(id)
                .orElseThrow(() -> new AppResourceNotFoundException("Could not find user with provided id " + id));
    }

    @Override
    public List<AppUser> findAll() {
        return appUserDAO.findAll();
    }

    @Override
    public AppUser update(String id, AppUserForm appUserForm) {
        AppUser appUser = findById(id);
        Optional<AppUser> optional = appUserDAO.findByUsername(appUserForm.getUsername().trim());
        if(optional.isPresent() && !id.equals(optional.get().getId())){
            throw new IllegalArgumentException("Username is already taken");
        }
        appUser.setUsername(appUserForm.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(appUserForm.getPassword()));
        appUser = appUserDAO.save(appUser);
        return appUser;
    }

    @Override
    public void delete(String id) {
        AppUser appUser = findById(id);
        appUser.setRoles(null);
        appUserDAO.deleteById(id);
    }
}
