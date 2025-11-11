package com.pluralsight.shop.sandwich;

public class PhillyCheeseSteak extends SignatureSandwich{


    public PhillyCheeseSteak( boolean isExtra) {
        super("Philly Cheese Steak", isExtra, "8", "white");
        addTopping(new Meat("Steak", true, isExtra));
        addTopping(new Cheese("American Cheese", true, isExtra));
        addTopping(new RegularTopping("Peppers"));
        addTopping(new Sauce("Mayo"));

    }

    @Override
    public double piceBySize(String size) {
        return 0;
    }
}
