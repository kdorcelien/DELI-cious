package com.pluralsight.shop.sandwich;

public class RegularTopping extends Topping {

    public RegularTopping(String name) {
        super(name, false, false);
    }

    @Override
    public double piceBySize(String size) {
        return 0;
    }
}
