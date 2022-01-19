package com.example.recipeDatabase.io;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONHandler {

    private static final JSONHandler INSTANCE = new JSONHandler();

    public static JSONHandler getInstance() {
        return INSTANCE;
    }

    private final ObjectMapper objectMapper;

    public JSONHandler() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
    }


    public <T> void serializeToFile(Collection<T> data, File file) {
        try {
            objectMapper.writeValue(file, data);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public <T> List<T> deserializeFromFile(File file, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        JavaType type = objectMapper.getTypeFactory().constructParametricType(List.class, clazz);
        try {
            result = objectMapper.readValue(file, type);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
