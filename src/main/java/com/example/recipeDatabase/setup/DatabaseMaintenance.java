package com.example.recipeDatabase.setup;

import com.example.recipeDatabase.data.AppRoleDAO;
import com.example.recipeDatabase.model.entity.AppRole;
import com.example.recipeDatabase.model.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
@Component
public class DatabaseMaintenance {

    private final AppRoleDAO appRoleDAO;
    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    public DatabaseMaintenance(AppRoleDAO appRoleDAO) {
        this.appRoleDAO = appRoleDAO;
    }

    @PostConstruct
    @Transactional
    public void postConstruction(){
        if(!profile.equals("test")){
            if(appRoleDAO.findAll().isEmpty()){
                for(UserRole role : UserRole.values()){
                    appRoleDAO.save(new AppRole(role));
                }
            }
        }

    }
}

