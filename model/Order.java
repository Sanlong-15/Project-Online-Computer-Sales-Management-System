package model;

import java.util.ArrayList;

public class Order {
    private int orderId;
    private Customer customer;
    private ArrayList<CartItem> orderedItems; 
    private Seller seller;
    private String orderDate;
    private double totalAmount;
    private String status;

    private static int totalOrders = 0;

    public Order(Customer customer, String orderDate, int orderId, Seller seller, ShoppingCart cart, String status, double totalAmount) {
        setOrderId(orderId);
        setCustomer(customer);
        setOrderDate(orderDate);
        setSeller(seller);
        setStatus(status);
        setTotalAmount(totalAmount);

        this.orderedItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            this.orderedItems.add(
                new CartItem(item.getProduct(), item.getQuantity())
            );
        }

        totalOrders++;
    }

    public ArrayList<CartItem> getOrderedItems() {
        return orderedItems;
    }

    public static int getTotalOrders() {
        return totalOrders;
    }

    public int getOrderId() {
        return orderId;
    }

    private void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        if (orderDate != null && !orderDate.isEmpty()) {
            this.orderDate = orderDate;
        }
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        if (totalAmount >= 0) {
            this.totalAmount = totalAmount;
        } else {
            System.out.println("Total amount cannot be negative. Value not updated.");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status != null && !status.isEmpty()) {
            this.status = status;
        }
    }
}