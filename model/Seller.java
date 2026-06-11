package model;

import java.util.ArrayList;

public class Seller extends Person {
    private String storeName;
    private ArrayList<Product> products;

    private static int sellerCount = 0;
    private int nextProductId = 1000;

    public Seller(int sellerId, String name, int age, String phone, String storeName) {
        super(sellerId, name, age, phone);
        setStoreName(storeName);
        this.products = new ArrayList<>();
        sellerCount++;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        if (storeName == null || storeName.trim().isEmpty()) {
            this.storeName = "Unknown Store";
        } else {
            this.storeName = storeName.trim();
        }
    }

    public boolean addProduct(Product product) {
        if (product == null) {
            System.out.println("Cannot add a null product.");
            return false;
        }

        if (product.getSeller() != this) {
            System.out.println("Cannot add " + product.getProductName() + " to " + storeName + ".");
            System.out.println("This product belongs to another seller.");
            return false;
        }

        if (!products.contains(product)) {
            products.add(product);
            return true;
        }

        return false;
    }

    public boolean addProduct(String productName, String brand, String category, double price, int stock) {
        Product product = new Product(nextProductId++, this, productName, brand, category, price, stock);
        return addProduct(product);
    }

    public boolean addProduct(int productId, String productName, double price) {
        Product product = new Product(productId, this, productName, "Unknown Brand", "General", price, 0);
        return addProduct(product);
    }

    public ArrayList<Product> getProductsCopy() {
        return new ArrayList<>(products);
    }

    public int getProductListSize() {
        return products.size();
    }

    public void displayProducts() {
        System.out.println("\nProducts sold by " + storeName + ":");

        if (products.isEmpty()) {
            System.out.println("No products yet.");
            return;
        }

        for (Product product : products) {
            product.displayInfo();
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Store Name: " + storeName);
        System.out.println("Products: " + products.size());
    }


    public static int getSellerCount() {
        return sellerCount;
    }
}