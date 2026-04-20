public class Order {
    private int orderId;
    private Customer customer;
    private Product product;
    private Seller seller;     
    private ShoppingCart shoppingCart;
    private String orderDate;
    private double totalAmount;
    private String status;

    public Order(Customer customer, String orderDate, int orderId, Product product, Seller seller, ShoppingCart shoppingCart, String status, double totalAmount) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.orderId = orderId;
        this.product = product;
        this.seller = seller;
        this.shoppingCart = shoppingCart;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
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

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    
}
