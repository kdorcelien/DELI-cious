package com.pluralsight.shop;

import com.pluralsight.constant.Customize;
import com.pluralsight.constant.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order<T extends Product> implements Customize<T> {
    private List<T> items = new ArrayList<>();
    private Date orderDate = new Date();


    @Override
    public void addItem(T item) {
        items.add(item);
    }

    @Override
    public void removeItem(T item) {
        items.remove(item);

    }


    public List<T> getItems() {
        return items;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double total() {
        double total = 0.0;
        for (T item : items) {
            if (item instanceof Bread sandwich) {
                total += item.getPrice(sandwich.getSize());
            } else if (item instanceof Drink drink) {
                total += item.getPrice(drink.getSize());
            } else {
                total += item.getPrice("");
            }
        }
        return total;
    }

    public boolean isValidOrder() {
        boolean hasSandwich = false;
        boolean hasDrinkOrChips = false;

        for (T item : items) {
            if (item instanceof Sandwich) hasSandwich = true;
            if (item instanceof Drink || item instanceof Chips) hasDrinkOrChips = true;
        }

        // must have a sandwich OR (drink/chips if no sandwiches)
        return hasSandwich || (!hasSandwich && hasDrinkOrChips);
    }

    @Override
    public String toString() {
        return "Order # " +
                items +
                "| orderDate:" + orderDate +
                "| Total: $" + total();
    }
}
