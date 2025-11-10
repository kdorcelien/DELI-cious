package com.pluralsight.shop;

import com.pluralsight.constant.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        Order<Product> order = new Order<>();

        while (true) {
            System.out.println("\n===== DELI-cious Home =====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> orderMenu(order);
                case "0" -> {
                    System.out.println("AU REVOIR");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void orderMenu(Order<Product> order) {
        while (true) {
            System.out.println("\n===== Order Menu =====");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    order.addItem((Product) makeSandwich());
                    showOrderSummary(order);
                }
                case "2" -> {
                    order.addItem((Product) makeDrink());
                    showOrderSummary(order);
                }
                case "3" -> {
                    order.addItem(makeChips());
                    showOrderSummary(order);
                }
                case "4" -> {
                    Checkout.processOrder(order);
                    return;
                }
                case "0" -> {
                    System.out.println("Order canceled.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }


    private static void showOrderSummary(Order<Product> order) {
        System.out.println("\n Current Order Summary:");
        System.out.println("----------------------------");
        for (Product item : order.getItems()) {
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
        }
        System.out.println("----------------------------");
        System.out.printf("Running Total: $%.2f%n", order.total());
        System.out.println("============================\n");
    }


    private static Sandwich makeSandwich() {
        System.out.println("\n-- Create Your Sandwich --");

        System.out.print("Choose bread (white, wheat, rye, wrap): ");
        String bread = scanner.nextLine().trim().toLowerCase();

        System.out.print("Choose size (4, 8, 12): ");
        String size = scanner.nextLine().trim();

        System.out.print("Toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().equalsIgnoreCase("yes");

        Sandwich sandwich = new Bread("Custom Sandwich", size, bread, toasted);


        addToppings("meat", sandwich, availableMeats());


        addToppings("cheese", sandwich, availableCheeses());


        addToppings("regular topping", sandwich, availableRegularToppings());


        addToppings("sauce", sandwich, availableSauces());

        System.out.println(" Sandwich added to order!");

        return sandwich;
    }

    private static void addToppings(String category, Sandwich sandwich, List<String> options) {
        System.out.println("\nAvailable " + category + "s: " + String.join(", ", options));
        System.out.print("Enter your choices separated by commas (or press Enter to skip): ");
        String input = scanner.nextLine().trim();

        if (!input.isEmpty()) {
            String[] selected = input.split(",");
            for (String name : selected) {
                name = name.trim().toLowerCase();

                switch (category) {
                    case "meat" -> sandwich.addTopping(new Meat(name, true, askExtra(name)));
                    case "cheese" -> sandwich.addTopping(new Cheese(name, true, askExtra(name)));
                    case "regular topping", "sauce" -> sandwich.addTopping(new RegularTopping(name));
                }
            }
        }
    }

    private static boolean askExtra(String name) {
        System.out.print("Extra " + name + "? (yes/no): ");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }


    private static Drink makeDrink() {
        System.out.print("Enter drink size (Small, Medium, Large): ");
        String size = scanner.nextLine().trim().toLowerCase();

        System.out.println(availableFlavor());
        System.out.print("Enter desired flavor: ");
        String flavor = scanner.nextLine().trim().toLowerCase();

        return new Drink(size, flavor);
    }


    private static Chips makeChips() {
        System.out.println(availableChips());
        System.out.print("Enter chip type: ");
        String type = scanner.nextLine().trim().toLowerCase();

        return new Chips(type);
    }

    private static List<String> availableFlavor() {
        return List.of("Lemonade, Watermelon, Sprite, Coke, Orange, Grape");
    }

    private static List<String> availableChips() {
        return List.of("Lays Classic, Doritos, Pringles, BBQ, Veggie Chips, Salt & Vinegar, Sun Chips");
    }

    private static List<String> availableMeats() {
        return List.of("steak", "ham", "salami", "roast beef", "chicken", "bacon");
    }

    private static List<String> availableCheeses() {
        return List.of("american", "provolone", "cheddar", "swiss");
    }

    private static List<String> availableRegularToppings() {
        return List.of("lettuce", "peppers", "onions", "tomatoes", "jalapenos",
                "cucumbers", "pickles", "guacamole", "mushrooms");
    }

    private static List<String> availableSauces() {
        return List.of("mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette");
    }
}

