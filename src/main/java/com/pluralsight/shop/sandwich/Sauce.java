package com.pluralsight.shop.sandwich;

public class Sauce extends Topping {

    public Sauce(String name) {
        super(name, false, false);
    }

    @Override
    public double piceBySize(String size) {
        return 0;
    }
}
