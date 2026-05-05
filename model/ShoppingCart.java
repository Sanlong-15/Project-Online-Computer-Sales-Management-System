package model;

import java.util.ArrayList;

public class ShoppingCart {
    private int cartId;
    private Customer customer;
    private ArrayList<CartItem> items;
    private double totalPrice;

    public ShoppingCart(int cartId, Customer customer) {
        this.cartId = cartId;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public int getCartId() {
        return cartId;
    }

    public Customer getCustomer() {
        return customer;
    }
}