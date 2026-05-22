package model;

import interfaces.Calculatable;
import interfaces.Displayable;

public class OrderItem implements Displayable, Calculatable {
    private int orderItemId;
    private int productId;
    private String productName;
    private String sellerName;
    private double unitPrice;
    private int quantity;

    private static int orderItemCount = 0;

    public OrderItem(int orderItemId, Product product, int quantity) {
        setOrderItemId(orderItemId);

        if (product != null) {
            this.productId = product.getProductId();
            this.productName = product.getProductName();
            this.unitPrice = product.getPrice();

            if (product.getSeller() != null) {
                this.sellerName = product.getSeller().getStoreName();
            } else {
                this.sellerName = "No Seller";
            }
        } else {
            this.productId = 0;
            this.productName = "Unknown Product";
            this.unitPrice = 0;
            this.sellerName = "No Seller";
        }

        setQuantity(quantity);
        orderItemCount++;
    }

    private void setOrderItemId(int orderItemId) {
        if (orderItemId > 0) {
            this.orderItemId = orderItemId;
        } else {
            this.orderItemId = 0;
        }
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public double getUnitPrice() {
        return unitPrice;
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

    @Override
    public double calculateTotal() {
        return unitPrice * quantity;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            productName +
            " | Seller: " + sellerName +
            " | Unit Price: $" + unitPrice +
            " | Quantity: " + quantity +
            " | Subtotal: $" + calculateTotal()
        );
    }

    public static int getOrderItemCount() {
        return orderItemCount;
    }
}
