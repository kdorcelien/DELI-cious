package com.pluralsight.shop;

import com.pluralsight.constant.Product;

public class Sides implements Product {
    private String side;

    public Sides(String side) {
        this.side = side;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getPrice(String size) {
        System.out.println("Sides are free");
        return 0;
    }
}
