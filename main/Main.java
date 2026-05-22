package main;

import model.*;

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
            "Laptop",
            750.0,
            5
        );

        Product mouse = new Product(
            102,
            seller1,
            "Logitech Wireless Mouse",
            "Logitech",
            "Accessory",
            15.0,
            20
        );

        Product keyboard = new Product(
            201,
            seller2,
            "Mechanical Keyboard",
            "Keychron",
            "Accessory",
            80.0,
            10
        );

        system.addProduct(laptop);
        system.addProduct(mouse);
        system.addProduct(keyboard);

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
    }
}