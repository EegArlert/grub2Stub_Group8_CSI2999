package com.example.grub2stub;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class OrderDetail {
    private static int nextOrderId = 100001;
    private int orderID;
    private int userId;

    private Customer customer;
    //Add if we have more time?
    //private OrderStatus status;

    public OrderDetail(Customer customer){
        this.orderID = nextOrderId++;
        this.userId = customer.getCustID();
        this.customer = customer;
        //this.status = OrderStatus;
    }

    public int getOrderID(){
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    //update status function

    public double calulateTotal(){
        double total = 0.0;
        Map<FoodItem, Integer> items = Cart.instance.getItems();
        for(Map.Entry<FoodItem, Integer> entry : items.entrySet()){
            FoodItem item = entry.getKey();
            int quantity = entry.getValue();
            total += item.getFoodPrice() * quantity;
        }
        return total;
    }

    public void displayOrderDetails(String fileName){
        try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))){
            Customer customer = getCustomer();
            writer.println("CUSTOMER COPY");
            writer.println("-------------");
            writer.println("Name : " + customer.getCustName());
            writer.println("Order Number: " + getOrderID());
            writer.println("Row: " + customer.getSeatRow() + " Seat: " + customer.getSeatNumber());
            printOrderItems(writer);
            writer.printf("Total Cost: $%.2f%n", calulateTotal());

            writer.println(" ");

            writer.println("MERCHANT COPY");
            writer.println("-------------");
            writer.println("Name : " + customer.getCustName());
            writer.println("Order Number: " + getOrderID());
            writer.println("Row: " + customer.getSeatRow() + " Seat: " + customer.getSeatNumber());
            printOrderItems(writer);
            writer.printf("Total Cost: $%.2f%n", calulateTotal());
        }
        catch  (IOException e){
            e.printStackTrace();
        }
    }

    public void printOrderItems(PrintWriter writer){
        Map<FoodItem, Integer> items = Cart.instance.getItems();
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()){
            FoodItem item = entry.getKey();
            int quantity = entry.getValue();
            double price = item.getFoodPrice() * quantity;
            String formattedPrice = String.format("%.2f", price);

            writer.printf("%-30s%-10s%-10s%n", item.getFoodName(), "Qty: " + quantity, "Price: $" + formattedPrice);
        }
    }
}
