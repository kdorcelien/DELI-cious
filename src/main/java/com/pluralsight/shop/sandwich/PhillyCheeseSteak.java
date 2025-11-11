package com.pluralsight.shop.sandwich;

public class PhillyCheeseSteak extends Sandwich{
    public PhillyCheeseSteak(String name, boolean isPremium, boolean isExtra, String size, String bread, boolean isToasted) {
        super(name, isPremium, isExtra, size, bread, isToasted);
    }

    @Override
    public double piceBySize(String size) {
        return 0;
    }
}
