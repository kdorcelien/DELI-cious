A Java-based console application that allows customers to create and customize sandwich orders, including signature sandwiches, drinks, and chips

Features
Create custom sandwiches or choose from signature options like:
BLT
Philly Cheese Steak
Add or remove:
Meats
Cheeses
Sauces
Regular toppings
Choose drink size and type
View running order summaries
Automatically calculates total cost
Generates and saves receipts to /src/main/resources/receipts/

This project demonstrates Object-Oriented Programming principles in Java using:
Inheritance (e.g., SignatureSandwich extends Sandwich)
Interfaces and Abstract Classes (e.g., Product, Topping)
Generics (e.g., Order<T extends Product>)

Below is one of the most interesting and flexible parts of the project —
the generic Order class that can handle any type of Product (sandwiches, drinks, chips, etc.)
and process if an order is valid while still enforcing compile-time type safety:

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

