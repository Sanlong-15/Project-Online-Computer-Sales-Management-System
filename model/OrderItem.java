package model;
public class OrderItem {
    private String productName;
    private double priceAtPurchase;
    private int quantity;

    public OrderItem(String productName, double priceAtPurchase, int quantity) {
        this.productName = productName;
        this.priceAtPurchase = priceAtPurchase;
        this.quantity = quantity;
    }

    // Constructor from CartItem (snapshot copy)
    public OrderItem(CartItem cartItem) {
        this.productName = cartItem.getProduct().getName();
        this.priceAtPurchase = cartItem.getProduct().getPrice();
        this.quantity = cartItem.getQuantity();
    }

    public String getProductName() {
        return productName;
    }

    public double getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubTotal() {
        return priceAtPurchase * quantity;
    }
}
