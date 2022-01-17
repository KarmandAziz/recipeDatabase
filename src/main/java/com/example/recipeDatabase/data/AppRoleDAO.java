package com.example.recipeDatabase.data;

import com.example.recipeDatabase.model.entity.AppRole;
import com.example.recipeDatabase.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AppRoleDAO extends JpaRepository<AppRole, String> {
    @Query("SELECT r FROM AppRole r WHERE r.userRole = :role")
    Optional<AppRole> findByUserRole(@Param("role") UserRole userRole);

}
