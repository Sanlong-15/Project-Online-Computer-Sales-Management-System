public class Customer  {
    private int customerId;
    private String name;
    private String age;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String postalCode; 

    private static int customerCount = 0;

    public Customer(String address, String age, String city, int customerId, String email, String name, String phone, String postalCode) {
        setAddress(address);
        setAge(age);
        setCity(city);
        setCustomerId(customerId);
        setEmail(email);
        setName(name);
        setPhone(phone);
        setPostalCode(postalCode);
        customerCount++;
    }

    public static int getCustomerCount() {
    return customerCount;
}

    public int getCustomerId() {
        return customerId;
    }

    private void setCustomerId(int customerId) {
        this.customerId = customerId;
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
    public String toString() {
        return "Customer [customerId=" + customerId + ", name=" + name + ", age=" + age + ", phone=" + phone + 
               ", email=" + email + ", address=" + address + ", city=" + city + ", postalCode=" + postalCode + "]";
    }
}