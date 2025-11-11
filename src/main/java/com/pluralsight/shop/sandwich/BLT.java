package com.pluralsight.shop.sandwich;

public class BLT extends SignatureSandwich{

    public BLT( boolean isExtra) {
        super("BLT", isExtra, "8", "White");
        addTopping(new Meat("Bacon", true, isExtra));
        addTopping(new Cheese("Cheddar", true, isExtra));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Tomato"));
        addTopping(new Sauce("Ranch"));
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
