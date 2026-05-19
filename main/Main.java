package main;

import model.*;

public class Main {
    public static void main(String[] args) {

        // Create Customer
        Customer customer = new Customer(1, "Sarah", 25, "123456789", "123 Main St", "sarah@email.com");

        // Create Seller
        Seller seller = new Seller(1, "Tech Store", 30, "098765432", "Tech Store");

        // Create Products
        Product p1 = new Product("Dell", "A powerful laptop for work and gaming", "Dell Laptop", 1500.0, 1, 10, seller);
        Product p2 = new Product("Samsung", "Latest smartphone with advanced features", "Samsung Smartphone", 800.0, 2, 20, seller);

        // Display Product Info
        p1.displayInfo();
        System.out.println();
        p2.displayInfo();
        System.out.println();

        // Create Cart
        ShoppingCart cart = new ShoppingCart(1, customer);

        // Add items
        cart.addItem(p1, 1);
        cart.addItem(p2, 2);

        // Display Cart
        cart.displayInfo();

        // Create Order (checkout)
        Order order = new Order(
            customer,
            "2026-05-05",
            1001,
            seller,
            cart,
            "Pending"
        );

        // Display Order
        order.displayInfo();
        
        // Print Order Receipt
        order.printReceipt();
           
        // Create Payment
        Payment payment = new Payment(
            order,
            "2026-05-06",
            5001,
            "Credit Card"
        );
        // Display Payment Receipt
        payment.printReceipt();

    }
}