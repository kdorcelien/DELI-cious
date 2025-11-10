package com.pluralsight.shop;

import com.pluralsight.constant.Product;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Checkout {

    public static void processOrder(Order<? extends Product> order) {
        if (!order.isValidOrder()) {
            System.out.println(" Invalid order: You must include at least one sandwich, or chips/drink if no sandwiches.");
            return;
        }


        System.out.println("\n===== RECEIPT =====");
        order.getItems().forEach(item -> {
            String name = item.getName();
            double price;

            if (item instanceof Sandwich sandwich) {
                price = item.getPrice(sandwich.getSize());
            } else if (item instanceof Drink drink) {
                price = item.getPrice(drink.getSize());
            } else {
                price = item.getPrice("");
            }

            System.out.printf("%s $%.2f%n", name, price);
        });

        System.out.println("----------------------------");
        System.out.printf("TOTAL: $%.2f%n", order.total());
        System.out.println("============================\n");


        saveReceipt(order);
    }

    private static void saveReceipt(Order<? extends Product> order) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String fileName = "receipts/" + formatter.format(order.getOrderDate()) + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("===== DELI-cious Order Receipt =====\n");
            writer.write("Date: " + order.getOrderDate() + "\n\n");

            for (Product item : order.getItems()) {
                double price;
                if (item instanceof Sandwich sandwich) {
                    price = item.getPrice(sandwich.getSize());
                } else if (item instanceof Drink drink) {
                    price = item.getPrice(drink.getSize());
                } else {
                    price = item.getPrice("");
                }

                writer.write(item.getName() + "  $" + String.format("%.2f", price) + "\n");
            }

            writer.write("\nTOTAL: $" + String.format("%.2f", order.total()) + "\n");
            writer.write("============================\n");
            System.out.println(" Receipt saved to: " + fileName);
        } catch (IOException e) {
            System.out.println("️ Error saving receipt: " + e.getMessage());
        }
    }
}
