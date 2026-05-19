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

    public int getCartId() {
        return cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    // ShoppingCart Class
    @Override
    public boolean addItem(Product product, int quantity) {

        if(product == null){
            return false;
        }
        if(quantity <=0){
            return false;
        }
        if(quantity > product.getStock()){
            return false;
        }

        items.add(new CartItem(product, quantity));
        return true;
    }

    @Override
    public boolean removeItemByProductId(int productId) {

        return items.removeIf(item ->
            item.getProduct()
            .getSerialNumberId()==productId
        );
    }

    @Override
    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubTotal();
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