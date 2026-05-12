package model;

import interfaces.Displayable;
import java.util.ArrayList;

public class Customer extends Person implements Displayable {
    private String email;
    private String address;
    private String city;
    private String postalCode; 
    private ShoppingCart cart;
    private ArrayList<Order> orders;
    private static int customerCount = 0;

    public Customer(int id, String name, String age, String phone, String email, String address, String city, String postalCode ) {

        super(id, name, age, phone);
        setEmail(email);
        setAddress(address);
        setCity(city);
        setPostalCode(postalCode);
        customerCount++;
    }

    public static int getCustomerCount() {
    return customerCount;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address != null && !address.isEmpty()) {
            this.address = address;
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city != null && !city.isEmpty()) {
            this.city = city;
        }
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        if (postalCode != null && !postalCode.isEmpty()) {
            this.postalCode = postalCode;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("===== CUSTOMER INFO =====");
        System.out.println("Customer ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Phone: " + getPhone());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getAddress());
        System.out.println("City: " + getCity());
        System.out.println("Postal Code: " + getPostalCode());
    }

}