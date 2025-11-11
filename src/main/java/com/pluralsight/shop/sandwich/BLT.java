package com.pluralsight.shop.sandwich;

public class BLT extends SignatureSandwich{

    public BLT() {
        super("BLT", false, "8", "White");
        addTopping(new Meat("Bacon", true, false));
        addTopping(new Cheese("Cheddar", true, false));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Tomato"));
        addTopping(new Sauce("Ranch"));
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
