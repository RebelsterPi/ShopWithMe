package com.example.dell.shopwithme;

/**
 * Created by DELL on 07-09-2018.
 */

class HandSet {
    private String id;
    private String model;
    private String manufacturer;
    private String price;
    private String quantity;
    private String image;



    public HandSet(String id, String model, String manufacturer, String price, String quantity, String image) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.image = image;

    }
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }
}
