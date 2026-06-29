package main;

import interfaces.BundleCalculator;
import interfaces.Calculatable;
import java.util.ArrayList;
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

        System.out.println("\n||======================================================================||");
        System.out.println("|| [SECTION 1] INHERITANCE                                ||");
        System.out.println("|| Customer and Seller both extend Person.                ||");
        System.out.println("|| They inherit: id, name, age, phone, and displayInfo(). ||");
        System.out.println("||======================================================================||");

        System.out.println("\n--- Customer inherits from Person ---");
        System.out.println("customer1.getId(): " + customer1.getId());
        System.out.println("customer1.getName(): " + customer1.getName());
        System.out.println("customer1.getAge(): " + customer1.getAge());
        System.out.println("customer1.getPhone(): " + customer1.getPhone());
        System.out.println("(These 4 getters are inherited from Person, not defined in Customer)");

        System.out.println("\n--- Seller inherits from Person ---");
        System.out.println("seller1.getId(): " + seller1.getId());
        System.out.println("seller1.getName(): " + seller1.getName());
        System.out.println("seller1.getAge(): " + seller1.getAge());
        System.out.println("seller1.getPhone(): " + seller1.getPhone());
        System.out.println("(These 4 getters are inherited from Person, not defined in Seller)");


        System.out.println("\n||======================================================================||");
        System.out.println("|| [SECTION 2] ABSTRACT CLASS                             ||");
        System.out.println("|| Person is abstract, so we cannot do new Person(...).   ||");
        System.out.println("|| We can only create Customer or Seller objects.          ||");
        System.out.println("||======================================================================||");

        System.out.println("\n||======================================================================||");
        System.out.println("|| [SECTION 3] METHOD OVERRIDING (@Override)              ||");
        System.out.println("|| Customer.displayInfo() and Seller.displayInfo()        ||");
        System.out.println("|| override Person.displayInfo().                         ||");
        System.out.println("|| Each calls super.displayInfo() first, then adds more.  ||");
        System.out.println("||======================================================================||");

        System.out.println("\n--- Customer.displayInfo() (overridden) ---");
        System.out.println("(Shows Person fields + Address, Email)");
        customer1.displayInfo();

        System.out.println("\n--- Seller.displayInfo() (overridden) ---");
        System.out.println("(Shows Person fields + Store Name, Products count)");
        seller1.displayInfo();

        System.out.println("\n||======================================================================||");
        System.out.println("|| [SECTION 4] METHOD OVERLOADING                         ||");
        System.out.println("|| Same method name, different parameter lists.            ||");
        System.out.println("||======================================================================||");

        System.out.println("\n--- 4a. Order.calculateTotal() has 3 overloads ---");

        System.out.println("\n[Overload 1] calculateTotal()  -->  no parameters");
        double totalNoDiscount = order1.calculateTotal();
        System.out.println("Total (no discount): $" + totalNoDiscount);

        System.out.println("\n[Overload 2] calculateTotal(double discount)  -->  percentage discount");
        double totalWith15Percent = order1.calculateTotal(15.0);
        System.out.println("Total (15% discount): $" + totalWith15Percent);

        System.out.println("\n[Overload 3] calculateTotal(String couponCode)  -->  coupon code");
        double totalWithSave10 = order1.calculateTotal("SAVE10");
        System.out.println("Total with SAVE10 coupon: $" + totalWithSave10);

        double totalWithSave20 = order1.calculateTotal("SAVE20");
        System.out.println("Total with SAVE20 coupon: $" + totalWithSave20);

        double totalWithWelcome50 = order1.calculateTotal("WELCOME50");
        System.out.println("Total with WELCOME50 coupon: $" + totalWithWelcome50);
        System.out.println("(WELCOME50 subtracts $50, but total will not go below $0)");

        double totalWithBadCoupon = order1.calculateTotal("FAKECODE");
        System.out.println("Total with invalid coupon: $" + totalWithBadCoupon);

        // Payment.pay() overloads
        System.out.println("\n--- 4b. Payment.pay() has 2 overloads ---");
        System.out.println("[Overload 1] pay()  -->  uses stored payment method");
        System.out.println("(Already called during processPayment above)");

        System.out.println("\n[Overload 2] pay(String paymentMethod)  -->  specify method at call time");
        Payment testPayment = new Payment(99, order1, "Cash");
        System.out.println("Trying testPayment.pay(\"ACLEDA\"):");
        testPayment.pay("ACLEDA");
        System.out.println("(Payment failed because order is already Paid, which is expected)");

        System.out.println("\n--- 4c. Seller.addProduct() has 3 overloads ---");

        System.out.println("\n[Overload 1] addProduct(Product product)  -->  pass a Product object");
        Product monitor = new Product(301, seller1, "LG Monitor", "LG", "Peripheral", 250.0, 15);
        seller1.addProduct(monitor);
        System.out.println("Added 'LG Monitor' via addProduct(Product)");

        System.out.println("\n[Overload 2] addProduct(String, String, String, double, int)  -->  auto-generate ID");
        seller1.addProduct("Logitech Mouse", "Logitech", "Peripheral", 35.0, 50);
        System.out.println("Added 'Logitech Mouse' via addProduct(String, String, String, double, int)");
        System.out.println("(Product ID is auto-generated, not 0!)");

        System.out.println("\n[Overload 3] addProduct(int, String, double)  -->  minimal info");
        seller2.addProduct(302, "USB Hub", 15.0);
        System.out.println("Added 'USB Hub' via addProduct(int, String, double)");

        System.out.println("\nSeller1 products after overloaded adds:");
        seller1.displayProducts();
        System.out.println("\nSeller2 products after overloaded adds:");
        seller2.displayProducts();

        System.out.println("\n--- 4d. ShoppingCart.addItem() has 2 overloads ---");
        Customer customer2 = new Customer(2, "Bopha", 22, "033333333", "Siem Reap", "bopha@example.com");
        system.addCustomer(customer2);
        system.addProduct(monitor);

        System.out.println("\n[Overload 1] addItem(Product, int quantity)  -->  specify quantity");
        customer2.getShoppingCart().addItem(monitor, 2);
        System.out.println("Added 2x LG Monitor via addItem(Product, int)");

        System.out.println("\n[Overload 2] addItem(Product)  -->  default quantity = 1");
        customer2.getShoppingCart().addItem(gamingLaptop);
        System.out.println("Added 1x ASUS ROG Laptop via addItem(Product) (default qty=1)");

        customer2.getShoppingCart().displayInfo();

        System.out.println("\n||======================================================================||");
        System.out.println("|| POLYMORPHISM                               ||");
        System.out.println("|| Person reference -> Customer or Seller object.          ||");
        System.out.println("|| Same method call, different behavior at runtime.        ||   ");
        System.out.println("||======================================================================||");

        System.out.println("\n[1] Person reference -> Customer object:");
        System.out.println("    Person personRef1 = customer1;");
        Person personRef1 = customer1;
        System.out.println("    personRef1.displayInfo() calls Customer's version:");
        personRef1.displayInfo();

        System.out.println("\n[2] Person reference -> Seller object:");
        System.out.println("    Person personRef2 = seller1;");
        Person personRef2 = seller1;
        System.out.println("    personRef2.displayInfo() calls Seller's version:");
        personRef2.displayInfo();

        System.out.println("\n[3] ArrayList<Person> with mixed Customer & Seller objects:");
        ArrayList<Person> people = new ArrayList<>();
        people.add(customer1);  
        people.add(customer2);
        people.add(seller1);    
        people.add(seller2);    
        System.out.println("    People in list: " + people.size());

        System.out.println("\n[4] Polymorphic loop, same call, different results:");
        for (Person person : people) {
            System.out.println("----------------------------------------");
            System.out.println("Declared type: Person");
            // System.out.println("Actual type:   " + person.getClass().getSimpleName());
            person.displayInfo();
        }

        System.out.println("========================================");
        System.out.println("Total people in list: " + people.size());

        System.out.println("\n||======================================================================||");
        System.out.println("|| ANONYMOUS INNER CLASS: Calculatable                    ||");
        System.out.println("|| No class name, defined and used in one place.          ||");
        System.out.println("||======================================================================||");

        Calculatable bundleDeal = new Calculatable() {
            private final double pricePerItem = 199.99;
            private final int quantity = 3;
            private final double discount = 50.0;

            @Override
            public double calculateTotal() {
                return (pricePerItem * quantity) - discount;
            }
        };

        System.out.println("Bundle Deal Total: $" + bundleDeal.calculateTotal());
        System.out.println("Is zero? " + bundleDeal.isZero());

        // LAMBDA EXPRESSION: 
        System.out.println("\n||======================================================================||");
        System.out.println("|| LAMBDA EXPRESSION: Calculatable                        ||");
        System.out.println("|| Same result as anonymous class, but no boilerplate.    ||");
        System.out.println("||======================================================================||");

        double pricePerItem = 199.99;
        int quantity = 3;
        double discount = 50.0;

        Calculatable bundleLambda = () -> (pricePerItem * quantity) - discount;

        System.out.println("Bundle Deal Total (lambda): $" + bundleLambda.calculateTotal());
        System.out.println("Is zero? " + bundleLambda.isZero());

        // CLEAR PARAMETER NAMES IN LAMBDA
        System.out.println("\n||======================================================================||");
        System.out.println("|| CLEAR PARAMETER NAMES IN LAMBDA                        ||");
        System.out.println("||======================================================================||");

        // BAD: short, unclear names and hard to read
        BundleCalculator bad = (p, q, d) -> (p * q) - d;

        // GOOD: full descriptive names and anyone can understand at a glance
        BundleCalculator good = (itemPrice, itemQuantity, itemDiscount) -> (itemPrice * itemQuantity) - itemDiscount;

        System.out.println("Bad names result : $" + bad.calculate(199.99, 3, 50.0));
        System.out.println("Good names result : $" + good.calculate(199.99, 3, 50.0));
    }
}