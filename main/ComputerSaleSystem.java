package main;

import interfaces.Displayable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.CartItem;
import model.Customer;
import model.Order;
import model.OrderItem;
import model.Payment;
import model.Product;
import model.Seller;
import model.ShoppingCart;

public class ComputerSaleSystem implements Displayable {
    private String systemName;
    private ArrayList<Customer> customers;
    private ArrayList<Seller> sellers;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    private ArrayList<Payment> payments;
    private HashMap<Integer, Product> productMap;

    public ComputerSaleSystem(String systemName) {
        if (systemName == null || systemName.trim().isEmpty()) {
            this.systemName = "Computer Sale System";
        } else {
            this.systemName = systemName.trim();
        }

        this.customers = new ArrayList<>();
        this.sellers = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.productMap = new HashMap<>();
    }

    public boolean addCustomer(Customer customer) {
        if (customer == null) {
            return false;
        }

        customers.add(customer);
        return true;
    }

    public boolean addSeller(Seller seller) {
        if (seller == null) {
            return false;
        }

        if (!sellers.contains(seller)) {
            sellers.add(seller);
        }

        return true;
    }

    public boolean addProduct(Product product) {
        if (product == null) {
            System.out.println("Cannot add a null product.");
            return false;
        }

        if (productMap.containsKey(product.getProductId())) {
            System.out.println("Product ID already exists: " + product.getProductId());
            return false;
        }

        Seller seller = product.getSeller();

        if (seller == null) {
            System.out.println("Product must belong to a seller.");
            return false;
        }

        addSeller(seller);
        seller.addProduct(product);
        products.add(product);
        productMap.put(product.getProductId(), product);
        return true;
    }

    public Customer searchCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }

        return null;
    }

    public Seller searchSellerById(int sellerId) {
        for (Seller seller : sellers) {
            if (seller.getSellerId() == sellerId) {
                return seller;
            }
        }

        return null;
    }

    public Product searchProductById(int productId) {
        return productMap.get(productId);
    }

    public Order searchOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }

        return null;
    }

    public Order checkoutCart(int orderId, Customer customer, String orderDate) {
        if (customer == null) {
            System.out.println("Cannot checkout without a customer.");
            return null;
        }

        if (searchOrderById(orderId) != null) {
            System.out.println("Order ID already exists: " + orderId);
            return null;
        }

        ShoppingCart cart = customer.getShoppingCart();

        if (cart == null || !cart.hasItems()) {
            System.out.println("Cannot checkout an empty cart.");
            return null;
        }

        ArrayList<CartItem> cartItems = cart.getCartItemsCopy();

        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();

            if (product == null) {
                System.out.println("Checkout failed: cart contains invalid product.");
                return null;
            }

            if (!product.hasEnoughStock(cartItem.getQuantity())) {
                System.out.println("Checkout failed: not enough stock for " + product.getProductName() + ".");
                return null;
            }
        }

        Order order = new Order(orderId, customer, orderDate);
        int orderItemId = 1;

        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            int quantity = cartItem.getQuantity();

            boolean stockReduced = product.reduceStock(quantity);

            if (!stockReduced) {
                System.out.println("Checkout failed while reducing stock.");
                return null;
            }

            OrderItem orderItem = new OrderItem(orderItemId, product, quantity);
            order.addOrderItem(orderItem);
            orderItemId++;
        }

        boolean confirmed = order.confirm();

        if (!confirmed) {
            System.out.println("Order " + orderId + " was not confirmed.");
            return null;
        }

        orders.add(order);
        customer.addOrder(order);
        cart.clearCart();

        System.out.println("Order " + orderId + " created successfully.");
        return order;
    }

    public boolean processPayment(Payment payment) {
        if (payment == null) {
            System.out.println("Cannot process a null payment.");
            return false;
        }

        boolean paid = payment.pay();

        if (paid) {
            payments.add(payment);
            System.out.println("Payment " + payment.getPaymentId() + " processed successfully.");
            return true;
        }

        System.out.println("Payment " + payment.getPaymentId() + " failed.");
        return false;
    }

    public void displayAllProducts() {
        System.out.println("\n========== Product Catalog ==========");

        if (productMap.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            entry.getValue().displayInfo();
        }

        System.out.println("=====================================");
    }

    public void displayAllOrders() {
        System.out.println("\nOrder history in " + systemName + ":");

        if (orders.isEmpty()) {
            System.out.println("No confirmed orders yet.");
            return;
        }

        for (Order order : orders) {
            order.displayInfo();
        }
    }

    public ArrayList<Customer> getCustomersCopy() {
        return new ArrayList<>(customers);
    }

    public ArrayList<Seller> getSellersCopy() {
        return new ArrayList<>(sellers);
    }

    public ArrayList<Product> getProductsCopy() {
        return new ArrayList<>(products);
    }

    public ArrayList<Order> getOrdersCopy() {
        return new ArrayList<>(orders);
    }

    public ArrayList<Payment> getPaymentsCopy() {
        return new ArrayList<>(payments);
    }

    public int getCustomerListSize() {
        return customers.size();
    }

    public int getSellerListSize() {
        return sellers.size();
    }

    public int getProductListSize() {
        return products.size();
    }

    public int getOrderListSize() {
        return orders.size();
    }

    public int getPaymentListSize() {
        return payments.size();
    }

    public int getProductMapSize() {
        return productMap.size();
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========== Computer Sale System Summary ==========");
        System.out.println("System Name: " + systemName);
        System.out.println("Customers: " + customers.size());
        System.out.println("Sellers: " + sellers.size());
        System.out.println("Products: " + products.size());
        System.out.println("Product Map: " + productMap.size());
        System.out.println("Orders: " + orders.size());
        System.out.println("Payments: " + payments.size());
        System.out.println("==================================================");
    }
}