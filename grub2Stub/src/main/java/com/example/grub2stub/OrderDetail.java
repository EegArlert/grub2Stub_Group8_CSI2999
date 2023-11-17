package com.example.grub2stub;

import java.util.ArrayList;
import java.util.List;
public class OrderDetail {
    private static int nextOrderId = 1;
    private int orderID;
    private int userId;
    private List<FoodItem> items;
    //Add if we have more time?
    //private OrderStatus status;

    public OrderDetail(int userId){
        this.orderID = nextOrderId++;
        this.userId = userId;
        this.items = new ArrayList<>();
        //this.status = OrderStatus;
    }

    public void addItem(FoodItem item){
        items.add(item);
    }

    public void removeItem(FoodItem item){
        items.remove(item);
    }

    //update status function

    public double calulateTotal(){
        double total = 0.0;
        for(FoodItem item: items){
            total += item.getFoodPrice();
        }
        return total;
    }

    public void displayOrderDetails(){

    }

}
