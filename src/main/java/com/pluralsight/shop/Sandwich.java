package com.pluralsight.shop;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwich extends Topping {
    protected String size, bread;
    protected boolean isToasted;
    protected List<Topping> toppings = new ArrayList<>();

    public Sandwich(String size, String bread, boolean isToasted) {
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
    }

    public void addTopping(Topping topping){
        toppings.add(topping);
    }

    public abstract double calcultePrice();

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
        if (isToasted){
            System.out.println(bread + "is perfectly toated");
        }
        return isToasted;
    }


}
