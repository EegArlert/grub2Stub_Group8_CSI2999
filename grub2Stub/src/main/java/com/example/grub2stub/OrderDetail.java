package com.example.grub2stub;

import java.util.ArrayList;
import java.util.List;
public class OrderDetail {
    private static int nextOrderId = 1;
    private int orderID;
    private int userId;
    private List<FoodItem> items;

    private Customer customer;
    //Add if we have more time?
    //private OrderStatus status;

    public OrderDetail(Customer customer, ArrayList<FoodItem> foodItemArrayList){
        this.orderID = nextOrderId++;
        this.userId = customer.getCustID();
        this.items = foodItemArrayList;
        this.customer = customer;
        //this.status = OrderStatus;
    }

    public void addItem(FoodItem item){
        items.add(item);
    }

    public void removeItem(FoodItem item){
        items.remove(item);
    }

    public int getOrderID(){
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<FoodItem> getFoodItemList(){
        return items;
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
        Customer customer = getCustomer();
        System.out.println("CUSTOMER COPY");
        System.out.println("-------------");
        System.out.println("Name : " + customer.getCustName());
        System.out.println("Order Number: " + getOrderID());
        System.out.println("Row: " + customer.getSeatRow() + " Seat: " + customer.getSeatNumber());
        printOrderItems();
        System.out.println("Total Cost: " + calulateTotal());

        System.out.println(" ");

        System.out.println("MERCHANT COPY");
        System.out.println("-------------");
        System.out.println("Name : " + customer.getCustName());
        System.out.println("Order Number: " + getOrderID());
        System.out.println("Row: " + customer.getSeatRow() + " Seat: " + customer.getSeatNumber());
        printOrderItems();
        System.out.println("Total Cost: " + calulateTotal());
    }

    public void printOrderItems(){
        for (FoodItem item : getFoodItemList()){
            System.out.printf("%-20s%-10s%-10s%n", item.getFoodName(), "Qty: " + item.getFoodQuantity(), "Price: $" + item.getFoodPrice() * item.getFoodQuantity());
        }
    }
}
