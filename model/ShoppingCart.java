package model;

public class ShoppingCart {
    private int cartId;
    private Customer customer;
    private Product product;
    private int quantity;
    private double totalPrice;

    public ShoppingCart(int cartId, Customer customer, Product product, int quantity, double totalPrice) {
        setCartId(cartId);
        setCustomer(customer);
        setProduct(product);
        setQuantity(quantity);
        setTotalPrice(totalPrice);
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity cannot be negative. Value not updated.");
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        if (totalPrice >= 0) {
            this.totalPrice = totalPrice;
        } else {
            System.out.println("Total price cannot be negative. Value not updated.");
        }
    }
}