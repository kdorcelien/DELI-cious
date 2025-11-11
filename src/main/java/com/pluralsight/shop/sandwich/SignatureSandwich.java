package com.pluralsight.shop.sandwich;

public class SignatureSandwich extends Sandwich{

    public SignatureSandwich(String name, boolean isExtra, String size, String bread) {
        super(name, true, isExtra, size, bread, true);
    }

    @Override
    public double piceBySize(String size) {
        return 0;
    }
}
