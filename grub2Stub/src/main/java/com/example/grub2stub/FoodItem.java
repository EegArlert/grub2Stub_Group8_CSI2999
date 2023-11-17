package com.example.grub2stub;

public class FoodItem {
    private int foodID;
    private String foodName;
    private int foodPrice;
    private int foodPointsValue;
    private int foodType;

    public FoodItem(int foodID, String foodName, int foodPrice, int foodPointsValue, int foodType) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodPointsValue = foodPointsValue;
        this.foodType = foodType;
    }

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    public int getFoodPointsValue() {
        return foodPointsValue;
    }

    public void setFoodPointsValue(int foodPointsValue) {
        this.foodPointsValue = foodPointsValue;
    }

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }
}