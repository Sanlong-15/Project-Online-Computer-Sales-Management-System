package main;

import model.*;

public class MainTest {
    public static void main(String[] args) {

        // Create customer
        Customer c1 = new Customer(
                "123 Main Street", "25", "City", 1,
                "email@test.com", "John", "012345678", "1000"
        );

        // Create seller
        Seller s1 = new Seller(201, "Jane", "28", "099999999");

        // Create 3 products
        Product p1 = new Product(1, "Dell",
                "Gaming laptop", "Laptop",
                1000.0, 201, 101, 10);

        Product p2 = new Product(1, "Logitech",
                "Wireless mouse", "Mouse",
                50.0, 201, 102, 20);

        Product p3 = new Product(1, "Razer",
                "Mechanical keyboard", "Keyboard",
                120.0, 201, 103, 15);

        // Add products to seller
        s1.addProduct(p1);
        s1.addProduct(p2);
        s1.addProduct(p3);

        // Create shopping cart
        ShoppingCart cart = new ShoppingCart(301, c1);

        // Add items to cart
        cart.addItem(p1, 1);
        cart.addItem(p2, 2);
        cart.addItem(p3, 1);

        // Calculate total
        double total = cart.calculateTotalPrice();
        System.out.println("Total Price: $" + total);

        // Create order
        Order o1 = new Order(c1, "2026-04-28", 1001, s1, cart,
                "Pending", total);

        // Display order items
        System.out.println("\nOrder Created:");
        for (CartItem item : o1.getOrderedItems()) {
            System.out.println(item.getProduct().getName() +
                    " x " + item.getQuantity());
        }

        System.out.println("Order Total: $" + o1.getTotalAmount());
    }
}