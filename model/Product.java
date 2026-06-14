package model;

import interfaces.Displayable;

public class Product implements Displayable {
    private int productId; 
    private Seller seller;
    private String productName;
    private String brand;
    private String category;
    private double price;
    private int stock;

    private static int productCount = 0;

    public Product(int productId, Seller seller, String productName, String brand, String category, double price, int stock) {
        setProductId(productId);
        this.seller = seller;
        this.productName = cleanText(productName, "Unknown Product");
        this.brand = cleanText(brand, "Unknown Brand");
        this.category = cleanText(category, "General");
        setPrice(price);
        setStock(stock);
        productCount++;
    }

    private String cleanText(String value, String defaultValue) {
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return value.trim();
    }

    private void setProductId(int productId) {
        if (productId > 0) {
            this.productId = productId;
        } else {
            this.productId = 0;
        }
    }

    public int getProductId() {
        return productId;
    }

    public Seller getSeller() {
        return seller;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setProductName(String productName) {
        if (productName != null && !productName.trim().isEmpty()) {
            this.productName = productName.trim();
        }
    }

    public void setBrand(String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand.trim();
        }
    }

    public void setCategory(String category) {
        if (category != null && !category.trim().isEmpty()) {
            this.category = category.trim();
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            this.price = 0;
        }
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            this.stock = 0;
        }
    }

    public boolean hasEnoughStock(int requestedQuantity) {
        return requestedQuantity > 0 && requestedQuantity <= stock;
    }

    public boolean reduceStock(int quantity) {
        if (!hasEnoughStock(quantity)) {
            System.out.println("Cannot reduce stock for " + productName + ". Requested quantity is invalid.");
            return false;
        }

        stock -= quantity;
        return true;
    }

    @Override
    public void displayInfo() {
        String sellerName = "No Seller";

        if (seller != null) {
            sellerName = seller.getStoreName();
        }

        System.out.println(
            "Product ID: " + productId +
            " | Product: " + productName +
            " | Brand: " + brand +
            " | Category: " + category +
            " | Seller: " + sellerName +
            " | Price: $" + price +
            " | Stock: " + stock
        );
    }

    public static int getProductCount() {
        return productCount;
    }
}
