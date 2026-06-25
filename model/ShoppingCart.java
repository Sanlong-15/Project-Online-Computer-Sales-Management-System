package model;

import interfaces.Calculatable;
import interfaces.Displayable;
import interfaces.Manageable;
import java.util.ArrayList;
public class ShoppingCart implements Displayable, Calculatable, Manageable {
    private Customer customer;
    private ArrayList<CartItem> cartItems;
    private int nextCartItemId;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
        this.cartItems = new ArrayList<>();
        this.nextCartItemId = 1;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean hasItems() {
        return !cartItems.isEmpty();
    }

    public ArrayList<CartItem> getCartItemsCopy() {
        return new ArrayList<>(cartItems);
    }

    private CartItem findCartItemByProductId(int productId) {
        for (CartItem item : cartItems) {
            if (item.getProduct() != null && item.getProduct().getProductId() == productId) {
                return item;
            }
        }

        return null;
    }

    @Override
    public boolean addItem(Product product, int quantity) {
        if (product == null) {
            System.out.println("Cannot add a null product to the cart.");
            return false;
        }

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return false;
        }

        CartItem existingItem = findCartItemByProductId(product.getProductId());
        int currentQuantity = 0;

        if (existingItem != null) {
            currentQuantity = existingItem.getQuantity();
        }

        int requestedTotalQuantity = currentQuantity + quantity;

        if (!product.hasEnoughStock(requestedTotalQuantity)) {
            System.out.println("Not enough stock for " + product.getProductName() + ".");
            System.out.println("Requested total quantity: " + requestedTotalQuantity);
            System.out.println("Available stock: " + product.getStock());
            return false;
        }

        if (existingItem != null) {
            existingItem.increaseQuantity(quantity);
        } else {
            cartItems.add(new CartItem(nextCartItemId, product, quantity));
            nextCartItemId++;
        }

        return true;
    }

    public boolean addItem(Product product) {
        return addItem(product, 1);
    }

    @Override
    public boolean removeItemByProductId(int productId) {
        CartItem item = findCartItemByProductId(productId);

        if (item == null) {
            System.out.println("Product ID " + productId + " was not found in the cart.");
            return false;
        }

        cartItems.remove(item);
        return true;
    }

    public void clearCart() {
        cartItems.clear();
    }

    @Override
    public double calculateTotal() {
        double total = 0;

        for (CartItem item : cartItems) {
            total += item.calculateTotal();
        }

        return total;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n========== Shopping Cart ==========");

        if (customer != null) {
            System.out.println("Customer: " + customer.getName());
        }

        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (CartItem item : cartItems) {
                item.displayInfo();
            }
        }

        System.out.println("Cart Total: $" + calculateTotal());
        System.out.println("===================================");
    }
}
