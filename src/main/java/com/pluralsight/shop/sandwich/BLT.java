package com.pluralsight.shop.sandwich;

public class BLT<T extends RegularTopping> extends Sandwich{
    private String bread,size;

    public BLT(String name, boolean isExtra, String size, String bread) {
        super(name, true, isExtra, size, bread, true);
    }

    @Override
    public double piceBySize(String size) {
        return 7.00;
    }

    @Override
    public String getBread() {
        return "white";
    }


    @Override
    public String getSize() {
        return "8";
    }

}
