// package main;

// import model.*;

// public class Main_1 {
//     public static void main(String[] args) {

//         // Create Customer
//         Customer customer = new Customer(
//             "Phnom Penh",   // address
//             "20",           // age
//             "Phnom Penh",   // city
//             1,              // customerId
//             "alice@email.com",
//             "Alice",
//             "012345678",
//             "12000"
//         );

//         // Create Seller
//         Seller seller = new Seller(1, "Tech Store", "30", "098765432");

//         // Create Products
//         Product p1 = new Product(1, "Dell", "A powerful laptop for work and gaming", "Laptop", 1500.0, 1, 10);
//         Product p2 = new Product(1, "Samsung", "Latest smartphone with advanced features", "Smartphone", 800.0, 2, 20);

//         // Display Product Info
//         p1.display();
//         System.out.println();
//         p2.display();
//         System.out.println();

//         // Create Cart
//         ShoppingCart cart = new ShoppingCart(1, customer);

//         // Add items
//         cart.addItem(p1, 1);
//         cart.addItem(p2, 2);

//         // Display Cart
//         System.out.println("=== CART ===");
//         for (CartItem item : cart.getItems()) {
//             System.out.println(
//                 item.getProduct().getName() +
//                 " | Qty: " + item.getQuantity() +
//                 " | Subtotal: $" + item.getSubTotal()
//             );
//         }

//         System.out.println("Cart Total: $" + cart.calculateTotalPrice());

//         // Create Order (checkout)
//         Order order = new Order(
//             customer,
//             "2026-05-05",
//             1001,
//             seller,
//             cart,
//             "Pending"
//         );

//         // Display Order
//         System.out.println("\n=== ORDER ===");
//         for (OrderItem item : order.getOrderedItems()) {
//             System.out.println(
//                 item.getProductName() +
//                 " | Qty: " + item.getQuantity() +
//                 " | Subtotal: $" + item.getSubTotal()
//             );
//         }

//         System.out.println("Order Total: $" + order.getTotalAmount());

//         System.out.println("\n=== TEST: Change Product Price ===");
//         p1.setPrice(2000.0);

//         System.out.println("Cart Total after price change: $" + cart.calculateTotalPrice());
//         System.out.println("Order Total after price change: $" + order.getTotalAmount());
//     }
// }
