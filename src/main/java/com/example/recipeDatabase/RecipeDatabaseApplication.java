package com.example.recipeDatabase;

import com.example.recipeDatabase.io.JSONHandler;
import com.example.recipeDatabase.model.entity.AppRole;
import com.example.recipeDatabase.model.entity.AppUser;
import com.example.recipeDatabase.model.entity.UserRole;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mashape.unirest.http.Unirest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.*;

import static com.example.recipeDatabase.model.entity.UserRole.ROLE_SUPER_ADMIN;

@SpringBootApplication
public class RecipeDatabaseApplication {


	public static void main(String[] args) {

		SpringApplication.run(RecipeDatabaseApplication.class, args);


	}




	public static void userToJSON(){
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		Set<AppRole> admin = new HashSet<>();
		admin.add(new AppRole(ROLE_SUPER_ADMIN));
		List<AppUser> appUsers = Arrays.asList(
				new AppUser(admin, "Admin1", bCryptPasswordEncoder.encode("Admin123")));
		JSONHandler jsonHandler = new JSONHandler();
		jsonHandler.serializeToFile(appUsers, new File("admin1.json"));
	}

}
