package com.pluralsight.shop;

public class RegularTopping extends Topping {

    public RegularTopping(String name, boolean isPremium, boolean isExtra) {
        super(name, false, false);
    }

    @Override
    public double piceBySize(String size) {
        System.out.println("Included");
        return 0;
    }
}
