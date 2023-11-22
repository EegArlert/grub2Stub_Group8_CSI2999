package com.example.grub2stub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    public ArrayList<FoodItem> readFoodItemsFromFile(String filePath) {
        ArrayList<FoodItem> foodItems = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    foodItems.add(new FoodItem(name, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
        return foodItems;
    }

        public void writeToFile(String filePath, ArrayList<String> data) throws IOException {
            // Implementation...
        }
    }

