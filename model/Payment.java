package model;

public class Payment {
    private int paymentId;
    private Order order;
    private String paymentMethod;
    private double amount;
    private String paymentDate;

    public Payment(double amount, Order order, String paymentDate, int paymentId, String paymentMethod) {
        setAmount(amount);
        setOrder(order);
        setPaymentDate(paymentDate);
        setPaymentId(paymentId);
        setPaymentMethod(paymentMethod);
    }

    public int getPaymentId() {
        return paymentId;
    }

    private void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        if (paymentMethod != null && !paymentMethod.isEmpty()) {
            this.paymentMethod = paymentMethod;
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            System.out.println("Amount cannot be negative. Value not updated.");
        }
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        if (paymentDate != null && !paymentDate.isEmpty()) {
            this.paymentDate = paymentDate;
        }
    }
}