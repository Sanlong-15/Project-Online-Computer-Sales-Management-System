package model;

import java.util.ArrayList;

public class Product {
    private int serialNumberId;
    private String name;
    private String brand;
    private double price;
    private int stock;
    private String description;
    private int adminId;

    private static int totalProducts = 0;

    private static ArrayList<Product> productList = new ArrayList<>();

    public Product(int adminId, String brand, String description, String name, double price, int serialNumberId, int stock) {
        setAdminId(adminId);
        setBrand(brand);
        setDescription(description);
        setName(name);
        setPrice(price);
        setSerialNumberId(serialNumberId);
        setStock(stock);
        totalProducts++;
    }
  
    public static int getTotalProducts() {
        return totalProducts;
    }

    public static void addProduct(Product product) {
        productList.add(product);
    }

    public static int getProductListSize() {
        return productList.size();
    }

    public static ArrayList<Product> getProductList() {
        return productList;
    }

    public int getSerialNumberId() {
        return serialNumberId;
    }

    private void setSerialNumberId(int serialNumberId) {
        this.serialNumberId = serialNumberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            this.brand = brand;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative. Value not updated.");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Stock cannot be negative. Value not updated.");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        }
    }

    public int getAdminId() {
        return adminId;
    }

    private void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "Product [serialNumberId=" + serialNumberId + ", name=" + name + ", brand=" + brand +
               ", price=" + price + ", stock=" + stock + ", description=" + description +
               ", adminId=" + adminId + "]";
    }
}