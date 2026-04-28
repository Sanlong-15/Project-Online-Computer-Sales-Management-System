package model;

public class Order {
    private int orderId;
    private Customer customer;
    private Product product;
    private Seller seller;
    private ShoppingCart cart;
    private String orderDate;
    private double totalAmount;
    private String status;

    private static int totalOrders = 0;

    public Order(Customer customer, String orderDate, int orderId, Product product, Seller seller, ShoppingCart cart, String status, double totalAmount) {
        setOrderId(orderId);
        setCustomer(customer);
        setOrderDate(orderDate);
        setProduct(product);
        setSeller(seller);
        setCart(cart);
        setStatus(status);
        setTotalAmount(totalAmount);
        totalOrders++;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
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