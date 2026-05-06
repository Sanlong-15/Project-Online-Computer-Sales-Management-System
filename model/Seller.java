package model;

import interfaces.Displayable;
import java.util.ArrayList;

public class Seller implements Displayable {
    private int sellerId;
    private ArrayList<Product> products;
    private String name;
    private String age;
    private String phone;

    public Seller(int sellerId, String name, String age, String phone) {
        setSellerId(sellerId);
        setName(name);
        setAge(age);
        setPhone(phone);
        this.products = new ArrayList<>();
    }

    public int getSellerId() {
        return sellerId;
    }

    private void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        if (age != null && !age.isEmpty()) {
            this.age = age;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone != null && !phone.isEmpty()) {
            this.phone = phone;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("===== SELLER INFO =====");
        System.out.println("ID: " + sellerId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phone);
    }
}