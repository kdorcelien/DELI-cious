package com.pluralsight.shop;

import com.pluralsight.constant.Custumize;
import com.pluralsight.constant.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order<T extends Product> implements Custumize<T> {
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
        return items.stream()
                .mapToDouble(item -> item.getPrice(size))
                .sum();
    }


}
