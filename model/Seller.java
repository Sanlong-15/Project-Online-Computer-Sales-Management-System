package model;

import interfaces.Displayable;
import java.util.ArrayList;

public class Seller extends Person implements Displayable {
    private ArrayList<Product> products;

    public Seller(int id, String name, String age, String phone) {
        super(id, name, age, phone);
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }


    // Seller Class
    @Override
    public void displayInfo() {
        System.out.println("===== SELLER INFO =====");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Phone: " + getPhone());
        System.out.println("Products:");
        for (Product product : products) {
            product.displayInfo();
        }
    }
}