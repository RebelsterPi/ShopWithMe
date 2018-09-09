package com.example.dell.shopwithme;

/**
 * Created by DELL on 09-09-2018.
 */

class Order {
private String model;
private String username;
private int quantity;

    public String getModel() {
        return model;
    }

    public String getUsername() {
        return username;
    }

    public int getQuantity() {
        return quantity;
    }

    public Order(String model, String username, int quantity) {
        this.model = model;
        this.username = username;
        this.quantity = quantity;

    }
}
