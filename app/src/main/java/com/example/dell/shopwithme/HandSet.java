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



    public HandSet( String model, String manufacturer, String price, String image) {

        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;

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
