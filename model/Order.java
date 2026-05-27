package model;

import java.util.ArrayList;
import interfaces.Calculatable;
import interfaces.Displayable;
import interfaces.Printable;

public class Order implements Displayable, Calculatable, Printable {
    private int orderId;
    private Customer customer;
    private ArrayList<OrderItem> orderItems;
    private String orderDate;
    private String status;

    private static int orderCount = 0;

    public Order(int orderId, Customer customer, String orderDate) {
        setOrderId(orderId);
        this.customer = customer;
        this.orderDate = cleanText(orderDate, "No Date");
        this.orderItems = new ArrayList<>();
        this.status = "Pending";
        orderCount++;
    }

    private String cleanText(String value, String defaultValue) {
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return value.trim();
    }

    private void setOrderId(int orderId) {
        if (orderId > 0) {
            this.orderId = orderId;
        } else {
            this.orderId = 0;
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public boolean hasItems() {
        return !orderItems.isEmpty();
    }

    public boolean isPaid() {
        return "Paid".equalsIgnoreCase(status);
    }

    public ArrayList<OrderItem> getOrderItemsCopy() {
        return new ArrayList<>(orderItems);
    }

    public boolean addOrderItem(OrderItem orderItem) {
        if (!"Pending".equalsIgnoreCase(status)) {
            System.out.println("Cannot add items. Order is already " + status + ".");
            return false;
        }

        if (orderItem == null) {
            System.out.println("Cannot add a null order item.");
            return false;
        }

        orderItems.add(orderItem);
        return true;
    }

    @Override
    public double calculateTotal() {
        double total = 0;

        for (OrderItem item : orderItems) {
            total += item.calculateTotal();
        }

        return total;
    }

    public double calculateTotal(double discount) {
    double total = calculateTotal();  

    if (discount < 0 || discount > 100) {
        System.out.println("Invalid discount. Must be between 0 and 100.");
        return total;
    }

    double discountAmount = total * discount / 100;
    return total - discountAmount;
    }

    public double calculateTotal(String couponCode) {
        double total = calculateTotal();  

        if (couponCode == null || couponCode.trim().isEmpty()) {
            return total;
        }

        String code = couponCode.trim().toUpperCase();

        if (code.equals("SAVE10")) {
            return total - (total * 10 / 100);
        } else if (code.equals("SAVE20")) {
            return total - (total * 20 / 100);
        } else if (code.equals("WELCOME50")) {
            return total - 50;  
        } else {
            System.out.println("Invalid coupon code: " + couponCode);
            return total;
        }
    }

    public boolean confirm() {
        if (!"Pending".equalsIgnoreCase(status)) {
            System.out.println("Order " + orderId + " is already " + status + ".");
            return false;
        }
        if (customer == null) {
            System.out.println("Order cannot be confirmed without a customer.");
            return false;
        }
        if (orderItems.isEmpty()) {
            System.out.println("Order cannot be confirmed without order items.");
            return false;
        }
        status = "Confirmed";
        return true;
    }

    public void markAsPaid() {
        if ("Confirmed".equalsIgnoreCase(status)) {
            status = "Paid";
        }
    }

    public void cancel() {
        if ("Paid".equalsIgnoreCase(status)) {
            System.out.println("Paid order cannot be cancelled in this simple version.");
            return;
        }

        status = "Cancelled";
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========== Order Detail ==========");
        System.out.println("Order ID: " + orderId);
        System.out.println("Date: " + orderDate);
        System.out.println("Status: " + status);

        if (customer != null) {
            System.out.println("Customer: " + customer.getName());
        }

        System.out.println("Items:");

        if (orderItems.isEmpty()) {
            System.out.println("No items in this order.");
        } else {
            for (OrderItem item : orderItems) {
                item.displayInfo();
            }
        }

        System.out.println("Total: $" + calculateTotal());
        System.out.println("==================================");
    }

    @Override
    public void print() {
        System.out.println("\n========== Order Receipt ==========");
        displayInfo();
    }

    public static int getOrderCount() {
        return orderCount;
    }
}
