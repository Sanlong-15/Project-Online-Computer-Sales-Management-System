package main;
import model.*;
import java.util.ArrayList;

public class OnlineComputerSaleManagementSystemMain {
    public static void main(String[] args) {

        System.out.println("||========== Object Creation ==========||");      

        Admin admin1 = new Admin(-10000000, "", "");
        System.out.println(admin1);

        Customer c1 = new Customer("123 Main Street", "30", "New York", 1,
                "john@email.com", "John Doe", "123-456-7890", "10001");
        System.out.println(c1);

        // temporary product
        Product tempProduct = new Product(0, "", "", "", 0.0, 0, 0, 0);
        Seller s1 = new Seller(201, tempProduct, "Jane Smith", "28", "555-111-2222");

        System.out.println("Seller ID: " + s1.getSellerId());
        System.out.println("Seller Name: " + s1.getName());
        System.out.println("Seller Age: " + s1.getAge());
        System.out.println("Seller Phone: " + s1.getPhone());

        Product p1 = new Product(admin1.getAdminId(), "Dell",
                "High-performance gaming laptop", "Gaming Laptop",
                1200.0, s1.getSellerId(), 101, 5);

        Product p2 = new Product(admin1.getAdminId(), "Apple",
                "MacBook Pro M3", "MacBook Pro",
                2500.0, s1.getSellerId(), 102, 3);

        s1.setProduct(p1);
        System.out.println(p1);

        // Storing Multiple Objects 
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);

        System.out.println("\n||========== Loop Through Collection ==========||");

        for (Product p : productList) {
            System.out.println(p);
        }

        System.out.println("\n||========== Shopping Cart ==========||");

        double cartTotal = p1.getPrice() * 2;
        ShoppingCart cart1 = new ShoppingCart(301, c1, p1, 2, cartTotal);

        System.out.println("Cart ID: " + cart1.getCartId());
        System.out.println("Customer: " + cart1.getCustomer().getName());
        System.out.println("Product: " + cart1.getProduct().getName());
        System.out.println("Quantity: " + cart1.getQuantity());
        System.out.println("Total Price: $" + cart1.getTotalPrice());

        System.out.println("\n||========== Order Information ==========||");

        Order o1 = new Order(c1, "2026-04-20", 1001, p1, s1, cart1,
                "Pending", cart1.getTotalPrice());

        System.out.println("Order ID: " + o1.getOrderId());
        System.out.println("Customer: " + o1.getCustomer().getName());
        System.out.println("Product: " + o1.getProduct().getName());
        System.out.println("Seller: " + o1.getSeller().getName());
        System.out.println("Order Date: " + o1.getOrderDate());
        System.out.println("Status: " + o1.getStatus());
        System.out.println("Total Amount: $" + o1.getTotalAmount());

        System.out.println("\n||========== Payment Information ==========||");

        Payment pay1 = new Payment(o1.getTotalAmount(), o1,
                "2026-04-20", 401, "Credit Card");

        System.out.println("Payment ID: " + pay1.getPaymentId());
        System.out.println("Order ID: " + pay1.getOrder().getOrderId());
        System.out.println("Payment Method: " + pay1.getPaymentMethod());
        System.out.println("Amount: $" + pay1.getAmount());
        System.out.println("Payment Date: " + pay1.getPaymentDate());

        System.out.println("\n||========== Static Counter Test ==========||");

        System.out.println("Total Products: " + Product.getTotalProducts());
        System.out.println("Total Customers: " + Customer.getCustomerCount());
        System.out.println("Total Orders: " + Order.getTotalOrders());
        System.out.println("Total Admins: " + Admin.getAdminCount());

        System.out.println("\n||========== Validation Test ==========||");

        p1.setPrice(-100);
        p1.setStock(-5);
        c1.setName("");  
        cart1.setQuantity(0);
        o1.setTotalAmount(-50);
        pay1.setAmount(-20);
    }
}