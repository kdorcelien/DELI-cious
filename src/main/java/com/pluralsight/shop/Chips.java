package com.pluralsight.shop;

import com.pluralsight.constant.Product;

public class Chips implements Product {
    private String type;

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return type + " Chips for: ";
    }

    @Override
    public double getPrice(String size) {
        return 1.50;
    }
}
