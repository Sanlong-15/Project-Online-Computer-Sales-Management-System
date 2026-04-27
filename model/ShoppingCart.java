import java.util.ArrayList;

public class ShoppingCart {
    private int cartId;
    private Customer customer;
    private ArrayList<Product> products;
    private double totalPrice;

    public ShoppingCart(int cartId, Customer customer) {
        setCartId(cartId);
        setCustomer(customer);
        setProducts(new ArrayList<>());
        setTotalPrice(0);
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTotalPrice(double totalPrice) {
        if (totalPrice >= 0) {
            this.totalPrice = totalPrice;
        }
    }

    public int getCartId() {
        return cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}