package com.example.recipeDatabase.database.daoimpl;

import com.example.recipeDatabase.database.daointerface.RecipeDAO;
import com.example.recipeDatabase.model.entity.Recipe;
import com.example.recipeDatabase.model.entity.RecipeIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@Transactional
public class RecipeDAOImpl implements RecipeDAO {

    private final EntityManager entityManager;

    @Autowired
    public RecipeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Recipe save(Recipe entity) {
        if(entity == null) throw new IllegalArgumentException("Entity was null");
        if(entity.getId() == null){
            entityManager.persist(entity);
        }else {
            return entityManager.merge(entity);
        }
        return entity;
    }

    @Override
    public Optional<Recipe> findById(String id) {
        return Optional.ofNullable(
                entityManager.find(Recipe.class, id));
    }

    @Override
    public List<Recipe> findAll() {
        return entityManager.createQuery("SELECT r FROM Recipe r", Recipe.class)
                .getResultList();
    }

    @Override
    public void delete(String id) {
        findById(id).ifPresent(entityManager::remove);

    }

    @Override
    public List<Recipe> findByRecipeName(String recipeName) {
        return entityManager.createQuery("SELECT r FROM Recipe r WHERE UPPER(r.recipeName) LIKE UPPER(CONCAT('%', :recipeName, '%'))", Recipe.class)
                .setParameter("recipeName", recipeName)
                .getResultList();

    }

    @Override
    public List<RecipeIngredient> findAllByRecipeIngredient(String recipeIngredient) {
        return entityManager.createQuery("SELECT r FROM RecipeIngredient r WHERE UPPER(r.ingredient) LIKE UPPER(CONCAT('%' :recipeIngredient, '%'))", RecipeIngredient.class)
                .setParameter("recipeIngredient", recipeIngredient)
                .getResultList();
    }

    @Override
    public List<Recipe> findByIngredientName(String ingredientName) {
        return null;
    }

    @Override
    public List<Recipe> findAllByCategories(String category) {
        return null;
    }

    @Override
    public Set<Recipe> findByAnyCategories(String... categories) {
        return null;
    }
}
