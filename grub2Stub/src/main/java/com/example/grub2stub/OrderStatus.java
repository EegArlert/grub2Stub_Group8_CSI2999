package com.example.grub2stub;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class OrderStatus {
    private static final OrderStatus instance = new OrderStatus();
    private final BooleanProperty orderPlaced = new SimpleBooleanProperty(false);

    private OrderStatus() {}

    public static OrderStatus getInstance() {
        return instance;
    }
    public BooleanProperty orderPlacedProperty() {
        return orderPlaced;
    }

    public boolean isOrderPlaced() {
        return orderPlaced.get();
    }

    public void setOrderPlaced(boolean placed) {
        orderPlaced.set(placed);
    }
}
