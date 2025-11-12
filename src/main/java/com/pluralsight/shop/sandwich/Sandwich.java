package com.pluralsight.shop.sandwich;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwich extends Topping {
    protected String size, bread;
    protected boolean isToasted;
    public List<Topping> toppings = new ArrayList<>();

    public Sandwich(String name, boolean isPremium, boolean isExtra, String size, String bread, boolean isToasted) {
        super(name, isPremium, isExtra);
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public void removeTopping(Topping topping){
        toppings.remove(topping);
    }

    public double getPrice(){
        return piceBySize(size) ;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public boolean isToasted() {
        return isToasted;
    }


}
