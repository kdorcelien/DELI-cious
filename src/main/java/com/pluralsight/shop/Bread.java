package com.pluralsight.shop;

import com.pluralsight.constant.Product;

public class Bread extends Sandwich implements Product {

    public Bread(String name, String size, String bread, boolean isToasted) {
        super(name, false, false, size, bread, isToasted);
    }

    @Override
    public double piceBySize(String size) {
        double basePrice;

        switch (size) {
            case "4" -> basePrice = 5.50;
            case "8" -> basePrice = 7.00;
            case "12" -> basePrice = 8.50;
            default -> basePrice = 0.0;
        }

        for (Topping topping : toppings) {
            basePrice += topping.piceBySize(size);
        }

        return basePrice;
    }

    @Override
    public String getName() {
        return size + " inch " + bread + " Sandwich";
    }

    @Override
    public double getPrice(String size) {
        return piceBySize(size);
    }
}
