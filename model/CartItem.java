package model;

import interfaces.Calculatable;
import interfaces.Displayable;

public class CartItem implements Displayable, Calculatable {
    private int cartItemId;
    private Product product;
    private int quantity;

    private static int cartItemCount = 0;

    public CartItem(int cartItemId, Product product, int quantity) {
        setCartItemId(cartItemId);
        this.product = product;
        setQuantity(quantity);
        cartItemCount++;
    }

    private void setCartItemId(int cartItemId) {
        if (cartItemId > 0) {
            this.cartItemId = cartItemId;
        } else {
            this.cartItemId = 0;
        }
    }

    public int getCartItemId() {
        return cartItemId;
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
        } else {
            this.quantity = 1;
        }
    }

    public void increaseQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
        }
    }

    @Override
    public double calculate() {
        if (product == null) {
            return 0;
        }
        return product.getPrice() * quantity;
    }

    @Override
    public void displayInfo() {
        if (product == null) {
            System.out.println("Invalid cart item: no product selected.");
            return;
        }
        System.out.println(
            product.getName() +
            " x " + quantity +
            " = $" + calculate()
        );
    }

    public static int getCartItemCount() {
        return cartItemCount;
    }
}