package com.pluralsight.shop.sandwich;

public class PhillyCheeseSteak extends SignatureSandwich{


    public PhillyCheeseSteak() {
        super("Philly Cheese Steak", false, "8", "white");
        addTopping(new Meat("Steak", true, false));
        addTopping(new Cheese("American Cheese", true, false));
        addTopping(new RegularTopping("Peppers"));
        addTopping(new Sauce("Mayo"));

    }

    @Override
    public double piceBySize(String size) {
        double basePrice;

        switch (size) {
            case "4" -> basePrice = 5.50;
            case "8" -> basePrice = 7.00;
            case "12" -> basePrice = 8.50;
            default -> basePrice = 0.0;
        }

        for (Topping topping : toppings) {
            basePrice += topping.piceBySize(size);
        }

        return basePrice;
    }

    @Override
    public String getBread() {
        return "white";
    }


    @Override
    public String getSize() {
        return "8";
    }
    @Override
    public double getPrice(String size) {
        return piceBySize("8");
    }
}
