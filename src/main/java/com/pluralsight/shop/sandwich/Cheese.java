package com.pluralsight.shop.sandwich;

public class Cheese extends Topping {


    public Cheese(String name, boolean isPremium, boolean isExtra) {
        super(name, isPremium, isExtra);
    }

    @Override
    public double piceBySize(String size) {
        if(isPremium) {
            double basePrice;

            switch (size) {
                case "4":
                    basePrice = 0.75;
                    break;
                case "8":
                    basePrice = 1.50;
                    break;
                case "12":
                    basePrice = 2.25;
                    break;
                default:
                    basePrice = 0.0;
            }

            if (isExtra) {
                switch (size) {
                    case "4" -> basePrice += 0.30;
                    case "8" -> basePrice += 0.60;
                    case "12" -> basePrice += 0.90;
                }
            }
            return basePrice;
        }
        return 0;
    }
}
