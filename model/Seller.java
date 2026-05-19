package model;

import java.util.ArrayList;

public class Seller extends Person {
    private String storeName;
    private ArrayList<Product> products;

    private static int sellerCount = 0;

    public Seller(int sellerId, String name, int age, String phone, String storeName) {
        super(sellerId, name, age, phone);
        setStoreName(storeName);
        this.products = new ArrayList<>();
        sellerCount++;
    }

    public int getSellerId() {
        return id;
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
            // after we all done I will open commentline
            // System.out.println("Cannot add " + product.getProductName() + " to " + storeName + ".");
            System.out.println("This product belongs to another seller.");
            return false;
        }

        if (!products.contains(product)) {
            products.add(product);
            return true;
        }

        return false;
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
        System.out.println("Seller ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phone);
        System.out.println("Store Name: " + storeName);
        System.out.println("Products: " + products.size());
    }

    public static int getSellerCount() {
        return sellerCount;
    }
}