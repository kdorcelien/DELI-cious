package com.pluralsight.constant;

public interface Customize<T> {
    void addItem(T item);
    void removeItem(T item);
}
