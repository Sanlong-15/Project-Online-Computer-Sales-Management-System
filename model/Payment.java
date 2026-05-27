package model;

import interfaces.Displayable;
import interfaces.Printable;

public class Payment implements Displayable, Printable {
    private int paymentId;
    private Order order;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    private static int paymentCount = 0;

    public Payment(int paymentId, Order order, String paymentMethod) {
        setPaymentId(paymentId);
        this.order = order;
        this.paymentMethod = cleanText(paymentMethod, "Unknown Method");
        this.paymentStatus = "Unpaid";
        this.amount = calculateAmountFromOrder();
        paymentCount++;
    }

    private String cleanText(String value, String defaultValue) {
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return value.trim();
    }

    private void setPaymentId(int paymentId) {
        if (paymentId > 0) {
            this.paymentId = paymentId;
        } else {
            this.paymentId = 0;
        }
    }

    private double calculateAmountFromOrder() {
        if (order == null) {
            return 0;
        }
        return order.calculateTotal();
    }

    public int getPaymentId() {
        return paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public boolean pay() {
        if (order == null) {
            System.out.println("Payment failed: no order connected.");
            return false;
        }
        if (!order.hasItems()) {
            System.out.println("Payment failed: order has no items.");
            return false;
        }
        if (!"Confirmed".equalsIgnoreCase(order.getStatus())) {
            System.out.println("Payment failed: order must be confirmed first.");
            return false;
        }
        amount = order.calculateTotal();
        if (amount <= 0) {
            System.out.println("Payment failed: amount must be greater than 0.");
            return false;
        }

        paymentStatus = "Paid";
        order.markAsPaid();
        return true;
    }

    public boolean pay(String paymentMethod) {
    if (paymentMethod == null || paymentMethod.trim().isEmpty()) {
        System.out.println("Payment method cannot be empty. Using stored method.");
        return pay();
    }

    String method = paymentMethod.trim();

    if (method.equalsIgnoreCase("ABA")
        || method.equalsIgnoreCase("ACLEDA")
        || method.equalsIgnoreCase("Cash")) {

        this.paymentMethod = method;
        return pay();
    } else {
        System.out.println("Payment method '" + method + "' is not supported.");
        System.out.println("Accepted methods: ABA, ACLEDA, Cash.");
        return false;
    }
}

    public boolean isPaid() {
        return "Paid".equalsIgnoreCase(paymentStatus);
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========== Payment Detail ==========");
        System.out.println("Payment ID: " + paymentId);

        if (order != null) {
            System.out.println("Order ID: " + order.getOrderId());
        }

        System.out.println("Amount: $" + amount);
        System.out.println("Method: " + paymentMethod);
        System.out.println("Status: " + paymentStatus);
        System.out.println("====================================");
    }

    @Override
    public void print() {
        System.out.println("\n========== Payment Receipt ==========");
        displayInfo();
    }

    public static int getPaymentCount() {
        return paymentCount;
    }
}
