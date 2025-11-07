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
        return size + "" + flavor + " For: ";
    }

    @Override
    public double getPrice(String size) {
        return switch (size){
            case "Small" -> 2.00;
            case "Medium" -> 2.50;
            case "Large" -> 3.00;
            default -> 0.0;
        };
    }
}

