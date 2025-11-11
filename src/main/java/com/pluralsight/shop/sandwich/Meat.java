package com.pluralsight.shop.sandwich;

public class Meat extends Topping {


    public Meat(String name, boolean isPremium, boolean isExtra) {
        super(name, isPremium, isExtra);
    }



    @Override
    public double piceBySize(String size) {
        if(isPremium) {
            double basePrice;

            switch (size) {
                case "4":
                    basePrice = 1.00;
                    break;
                case "8":
                    basePrice = 2.00;
                    break;
                case "12":
                    basePrice = 3.00;
                    break;
                default:
                    basePrice = 0.0;
            }

            if (isExtra) {
                switch (size) {
                    case "4" -> basePrice += 0.50;
                    case "8" -> basePrice += 1.00;
                    case "12" -> basePrice += 1.50;
                }
            }
        return basePrice;
    }
        return 0;
    }

}
