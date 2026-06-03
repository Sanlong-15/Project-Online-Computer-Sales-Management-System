package main;

import model.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ComputerSaleSystem system = new ComputerSaleSystem("CAM Computer Sale");

        Customer customer1 = new Customer(
            1,
            "Dara",
            20,
            "012345678",
            "Phnom Penh",
            "dara@example.com"
        );

        Seller seller1 = new Seller(1, "Sokha", 30, "011111111", "Sokha Computer Store");
        Seller seller2 = new Seller(2, "Vanda", 28, "022222222", "Vanda Tech Shop");

        system.addCustomer(customer1);
        system.addSeller(seller1);
        system.addSeller(seller2);

        Product laptop = new Product(
            101,
            seller1,
            "Lenovo ThinkPad",
            "Lenovo",
            "Computer",
            750.0,
            5
        );

        Product desktop = new Product(
            102,
            seller1,
            "Dell Desktop PC",
            "Dell",
            "Computer",
            900.0,
            20
        );

        Product gamingLaptop = new Product(
            201,
            seller2,
            "ASUS ROG Laptop",
            "ASUS",
            "Computer",
            80.0,
            10
        );

        system.addProduct(laptop);
        system.addProduct(desktop);
        system.addProduct(gamingLaptop);

        System.out.println("Before order:");
        system.displayAllProducts();

        Product wrongSelection = system.searchProductById(999);

        if (wrongSelection == null) {
            System.out.println("\nInvalid product selection: Product ID 999 does not exist.");
        }

        Product selectedProduct1 = system.searchProductById(101);
        Product selectedProduct2 = system.searchProductById(102);
        Product selectedProduct3 = system.searchProductById(201);

        customer1.getShoppingCart().addItem(selectedProduct1, 1);
        customer1.getShoppingCart().addItem(selectedProduct2, 2);
        customer1.getShoppingCart().addItem(selectedProduct3, 3);

        customer1.getShoppingCart().displayInfo();

        Order order1 = system.checkoutCart(1, customer1, "2026-05-18");

        if (order1 != null) {
            Payment payment1 = new Payment(1, order1, "ABA");
            system.processPayment(payment1);

            System.out.println("\nAfter order and payment:");
            order1.displayInfo();
            payment1.displayInfo();
        }

        System.out.println("\nProducts after checkout:");
        system.displayAllProducts();

        Order foundOrder = system.searchOrderById(1);

        if (foundOrder != null) {
            System.out.println("\nSearch result for Order 1:");
            foundOrder.displayInfo();
        }

        customer1.displayOrderHistory();
        seller1.displayProducts();
        seller2.displayProducts();
        system.displayInfo();

        System.out.println("\nStatic counters vs collection size:");
        System.out.println("Customer.getCustomerCount(): " + Customer.getCustomerCount());
        System.out.println("system.getCustomerListSize(): " + system.getCustomerListSize());

        System.out.println("Seller.getSellerCount(): " + Seller.getSellerCount());
        System.out.println("system.getSellerListSize(): " + system.getSellerListSize());

        System.out.println("Product.getProductCount(): " + Product.getProductCount());
        System.out.println("system.getProductListSize(): " + system.getProductListSize());

        System.out.println("Order.getOrderCount(): " + Order.getOrderCount());
        System.out.println("system.getOrderListSize(): " + system.getOrderListSize());

        System.out.println("OrderItem.getOrderItemCount(): " + OrderItem.getOrderItemCount());
        System.out.println("CartItem.getCartItemCount(): " + CartItem.getCartItemCount());

        System.out.println("Payment.getPaymentCount(): " + Payment.getPaymentCount());
        System.out.println("system.getPaymentListSize(): " + system.getPaymentListSize());

        System.out.println("\n========== Polymorphism Test ==========");
        System.out.println("\n[1] Person reference -> Customer object:");
        Person personRef1 = customer1;
        personRef1.displayInfo();

        System.out.println("\n[2] Person reference -> Seller object:");
        Person personRef2 = seller1;
        personRef2.displayInfo();

        System.out.println("\n[3] ArrayList<Person> with mixed objects:");
        ArrayList<Person> people = new ArrayList<>();
        people.add(customer1);  
        people.add(seller1);    
        people.add(seller2);    
        System.out.println("People in list: " + people.size());

        System.out.println("\n[4] Polymorphic loop same call, different results:");
        for (Person person : people) {
            System.out.println("----------------------------------------");
            System.out.println("Real type: " + person.getClass().getSimpleName());
            person.displayInfo();
        }

        System.out.println("========================================");
        System.out.println("Total people in list: " + people.size());
    }
}