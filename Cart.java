package com.example.grub2stub;
import java.util.HashMap;
import java.util.Map;
public class Cart {
    //Static instance of the cart, ensuring a single shared instance (Singleton pattern)
    private static Cart instance = new Cart();

    // Map to store FoodItems and their quantities
    private final Map<FoodItem, Integer> items;

    // Private constructor to prevent instantiation from outside the class
    private Cart() {
        items = new HashMap<>();
    }

    // Static method to get the instance of the cart
    public static Cart getInstance() {
        return instance;
    }

    // Method to retrieve the items in the cart
    public Map<FoodItem, Integer> getItems() {
        return items;
    }

    // Method to add an item to the cart, or increase its quantity if already present
    public void addItem(FoodItem item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    // Method to remove an item from the cart completely
    public void removeItem(FoodItem item) {
        items.remove(item);
    }

    // Method to clear all items from the cart
    public void clearCart() {
        items.clear();
    }
}
