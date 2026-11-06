
package com.eventmanagement.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static void saveToJson(Object data, String fileName) {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                  .writeValue(new File(fileName), data);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static <T> List<T> loadListFromJson(
            String fileName, TypeReference<List<T>> type) {

        File file = new File(fileName);

        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try {
            return mapper.readValue(file, type);
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
