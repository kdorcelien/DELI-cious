package com.pluralsight.shop;

public abstract class Topping {
    protected String name;
    protected boolean isPremium;

    public Topping(String name, boolean isPremium) {
        this.name = name;
        this.isPremium = isPremium;
    }

    public abstract double piceBySize(String Size);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremium() {
        return isPremium;
    }

}
