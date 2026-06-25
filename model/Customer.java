package model;

import java.util.ArrayList;

public class Customer extends Person {
    private String address;
    private String email;
    private ShoppingCart shoppingCart;
    private ArrayList<Order> orders;

    private static int customerCount = 0;

    public Customer(int customerId, String name, int age, String phone, String address, String email) {
        super(customerId, name, age, phone);
        setAddress(address);
        setEmail(email);
        this.shoppingCart = new ShoppingCart(this);
        this.orders = new ArrayList<>();
        customerCount++;
    }


    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            this.address = "No Address";
        } else {
            this.address = address.trim();
        }
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            this.email = "No Email";
        } else {
            this.email = email.trim();
        }
    }

    public void addOrder(Order order) {
        if (order != null && !orders.contains(order)) {
            orders.add(order);
        }
    }

    public ArrayList<Order> getOrdersCopy() {
        return new ArrayList<>(orders);
    }

    public int getOrderHistorySize() {
        return orders.size();
    }

    public void displayOrderHistory() {
        System.out.println("\nOrder History for " + getName() + ":");

        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }

        for (Order order : orders) {
            order.displayInfo();
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Address: " + address);
        System.out.println("Email: " + email);
    }


    @Override
    public String getRole() {
        return "Customer";
    }

    public static int getCustomerCount() {
        return customerCount;
    }
}
