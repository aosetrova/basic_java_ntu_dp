package org.example.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.unit.University;

import java.io.*;
public class JsonManager {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveToJsonFile(University university, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(university, writer);
        }
    }

    public static University loadFromJsonFile(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, University.class);
        }
    }
}
