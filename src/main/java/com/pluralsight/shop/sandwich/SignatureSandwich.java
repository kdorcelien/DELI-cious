package com.pluralsight.shop.sandwich;

import com.pluralsight.constant.Product;

public class SignatureSandwich extends Sandwich implements Product {

    public SignatureSandwich(String name, boolean isExtra, String size, String bread) {
        super(name, true, isExtra, size, bread, true);
    }

    @Override
    public double piceBySize(String size) {
        return 0;
    }

    @Override
    public double getPrice(String size) {
        return 0;
    }
}
