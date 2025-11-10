package com.pluralsight.shop;

public class RegularTopping extends Topping {

    public RegularTopping(String name) {
        super(name, false, false);
    }

    @Override
    public double piceBySize(String size) {
        System.out.println("regular topping is free");
        return 0;
    }
}
