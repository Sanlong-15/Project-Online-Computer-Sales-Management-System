import java.util.ArrayList;

public class Order {
    private int orderId;
    private Customer customer;
    private ArrayList<Product> products;
    private Seller seller;
    private String orderDate;
    private double totalAmount;
    private String status;

    private static int totalOrders = 0;

    public Order(int orderId, Customer customer, Seller seller, String orderDate, String status) {
        setOrderId(orderId);
        setCustomer(customer);
        setSeller(seller);
        setOrderDate(orderDate);
        setStatus(status);
        this.products = new ArrayList<>();
        this.totalAmount = 0;
        totalOrders++;
    }

    public ArrayList<Product> getProducts() {
        return products;
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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}