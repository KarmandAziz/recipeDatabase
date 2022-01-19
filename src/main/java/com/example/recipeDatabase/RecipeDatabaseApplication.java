package com.example.recipeDatabase;

import com.example.recipeDatabase.io.JSONHandler;
import com.example.recipeDatabase.model.entity.AppRole;
import com.example.recipeDatabase.model.entity.AppUser;
import com.example.recipeDatabase.model.entity.UserRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.*;

import static com.example.recipeDatabase.model.entity.UserRole.ROLE_SUPER_ADMIN;

@SpringBootApplication
public class RecipeDatabaseApplication {

	public static void main(String[] args) {
		/* Set<AppRole> admin = new HashSet<>();
		admin.add(new AppRole(ROLE_SUPER_ADMIN));
		List<AppUser> appUsers = Arrays.asList(
				new AppUser(admin, "Karmand94", "Hanna123"));
		JSONHandler jsonHandler = new JSONHandler();
		jsonHandler.serializeToFile(appUsers, new File("admin.json")); */


		SpringApplication.run(RecipeDatabaseApplication.class, args);


	}

}
