package com.pluralsight.shop.sandwich;

public abstract class Topping {
    public Object toppings;
    protected String name;
    protected boolean isPremium;
    protected boolean isExtra;

    public Topping(String name, boolean isPremium, boolean isExtra) {
        this.name = name;
        this.isPremium = isPremium;
        this.isExtra = isExtra;
    }

    public abstract double piceBySize(String size);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isExtra() {
        return isExtra;
    }
}
