package com.pluralsight.shop;

import com.pluralsight.constant.Product;

public class Drink implements Product {
    private String size, flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    @Override
    public String getName() {
        return size + " " + flavor + " For: ";
    }

    @Override
    public double getPrice(String size) {
        return switch (size){
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}

