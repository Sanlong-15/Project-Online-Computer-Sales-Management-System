package model;

import interfaces.Calculatable;
import interfaces.Displayable;

public class CartItem implements Displayable, Calculatable {
    private Product product;
    private int quantity;
    int status; // 0 = in cart, 1 = ordered

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        }
    }

    public double getSubTotal() {
        return product.getPrice() * quantity;
    }
    // CartItem Class
    @Override
    public double calculateTotal() {
        return getSubTotal();
    }
    
    @Override
    public void displayInfo() {
        System.out.println("===== CART ITEM =====");
        System.out.println("Product: " + product.getName());
        System.out.println("Quantity: " + quantity);
        System.out.println("Subtotal: $" + calculateTotal());
    }

}