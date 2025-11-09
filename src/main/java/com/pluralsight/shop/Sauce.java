package com.pluralsight.shop;

public class Sauce extends Topping{

    public Sauce(String name) {
        super(name, false, false);
    }

    @Override
    public double piceBySize(String size) {
        System.out.println("Included");
        return 0;
    }
}
