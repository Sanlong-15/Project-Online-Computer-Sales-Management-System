package model;

import interfaces.Calculatable;
import interfaces.Displayable;
import interfaces.Manageable;
import java.util.ArrayList;

public class ShoppingCart implements Displayable, Calculatable, Manageable {
    private int cartId;
    private Customer customer;
    private ArrayList<CartItem> items;

    public ShoppingCart(int cartId, Customer customer) {
        this.cartId = cartId;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        double total = 0;

        for (CartItem item : items) {
            total += item.getSubTotal();
        }

        return total;
    }

    public int getCartId() {
        return cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void addItem(Product product, int quantity) {

        if (quantity <= product.getStock()) {
            items.add(new CartItem(product, quantity));
            System.out.println("Item added to cart.");
        } else {
            System.out.println("Not enough stock available.");
        }
    }

    @Override
    public void removeItem(Product product) {

        items.removeIf(item ->
            item.getProduct().getSerialNumberId()
            == product.getSerialNumberId());

        System.out.println("Item removed from cart.");
    }

    @Override
    public double calculateTotal() {

        double total = 0;

        for (CartItem item : items) {
            total += item.calculateTotal();
        }

        return total;
    }

    @Override
    public void displayInfo() {

        System.out.println("===== SHOPPING CART =====");
        System.out.println("Cart ID: " + cartId);
        System.out.println("Customer: " + customer.getName());

        for (CartItem item : items) {
            item.displayInfo();
        }

        System.out.println("Total Price: $" + calculateTotal());
    }


}