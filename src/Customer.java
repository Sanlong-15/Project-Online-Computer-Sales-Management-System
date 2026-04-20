public class Customer  {
    private int customerId;
    private String name;
    private String age;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String postalCode; 

    public Customer(String address, String age, String city, int customerId, String email, String name, String phone, String postalCode) {
        this.address = address;
        this.age = age;
        this.city = city;
        this.customerId = customerId;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.postalCode = postalCode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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
}
