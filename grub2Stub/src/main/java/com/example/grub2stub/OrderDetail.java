package com.example.grub2stub;

import java.util.Map;

public class OrderDetail {
    private static int nextOrderId = 1;
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

    public void displayOrderDetails(){
        Customer customer = getCustomer();
        System.out.println("CUSTOMER COPY");
        System.out.println("-------------");
        System.out.println("Name : " + customer.getCustName());
        System.out.println("Order Number: " + getOrderID());
        System.out.println("Row: " + customer.getSeatRow() + " Seat: " + customer.getSeatNumber());
        printOrderItems();
        System.out.printf("Total Cost: $%.2f%n", calulateTotal());

        System.out.println(" ");

        System.out.println("MERCHANT COPY");
        System.out.println("-------------");
        System.out.println("Name : " + customer.getCustName());
        System.out.println("Order Number: " + getOrderID());
        System.out.println("Row: " + customer.getSeatRow() + " Seat: " + customer.getSeatNumber());
        printOrderItems();
        System.out.printf("Total Cost: $%.2f%n", calulateTotal());
    }

    public void printOrderItems(){
        Map<FoodItem, Integer> items = Cart.instance.getItems();
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()){
            FoodItem item = entry.getKey();
            int quantity = entry.getValue();
            double price = item.getFoodPrice() * quantity;
            String formattedPrice = String.format("%.2f", price);

            System.out.printf("%-30s%-10s%-10s%n", item.getFoodName(), "Qty: " + quantity, "Price: $" + formattedPrice);
        }
    }
}
