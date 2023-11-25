package com.example.grub2stub;

import java.util.Objects;

public class FoodItem {
    private String foodName;
    private double foodPrice;

    public FoodItem(String foodName, double foodPrice) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return Double.compare(foodItem.foodPrice, foodPrice) == 0 &&
                Objects.equals(foodName, foodItem.foodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName, foodPrice);
    }
}

