package main;

import model.*;

public class Main {
    public static void main(String[] args) {

        // Create Customer
        Customer customer = new Customer(
            "Phnom Penh",   
            "20",           
            "Phnom Penh",   
            1,              
            "alice@email.com",
            "Alice",
            "012345678",
            "12000"
        );

        // Create Seller
        Seller seller = new Seller(1, "Tech Store", "30", "098765432");

        // Create Products
        Product p1 = new Product(1, "Dell", "A powerful laptop for work and gaming", "Laptop", 1500.0, 1, 10);
        Product p2 = new Product(1, "Samsung", "Latest smartphone with advanced features", "Smartphone", 800.0, 2, 20);

        // Display Product Info
        p1.display();
        System.out.println();
        p2.display();
        System.out.println();

        // Create Cart
        ShoppingCart cart = new ShoppingCart(1, customer);

        // Add items
        cart.addItem(p1, 1);
        cart.addItem(p2, 2);

        // Display Cart
        cart.display();

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
        order.display();
        
        // Print Order Receipt
        // System.out.println("About to call order.printSummary()");
        order.printSummary();
           
        // Create Payment
        Payment payment = new Payment(
            order.getTotalAmount(),
            order,
            "2026-05-06",
            5001,
            "Credit Card"
        );
        // Display Payment Summary
        payment.printSummary();

    }
}