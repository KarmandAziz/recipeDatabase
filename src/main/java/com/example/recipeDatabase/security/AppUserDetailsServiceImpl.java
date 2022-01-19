package com.example.recipeDatabase.security;

import com.example.recipeDatabase.data.AppUserDAO;
import com.example.recipeDatabase.model.entity.AppRole;
import com.example.recipeDatabase.model.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AppUserDetailsServiceImpl implements UserDetailsService {

    private final AppUserDAO appUserDAO;

    @Autowired
    public AppUserDetailsServiceImpl(AppUserDAO appUserDAO) {
        this.appUserDAO = appUserDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " was not found"));

        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.setUserId(appUser.getId());
        appUserDetails.setUsername(appUser.getUsername());
        appUserDetails.setPassword(appUser.getPassword());
        appUserDetails.setActive(true);
        Set<SimpleGrantedAuthority> authoritySet = new HashSet<>();
        for(AppRole appRole : appUser.getRoles()){
            authoritySet.add(new SimpleGrantedAuthority(appRole.getUserRole().name()));
        }
        appUserDetails.setAuthorities(authoritySet);
        return appUserDetails;

    }
}
