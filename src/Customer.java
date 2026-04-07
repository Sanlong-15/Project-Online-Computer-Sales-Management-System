public class Customer  {
    private int customerId;
    private String name;
    private String age;
    private String phone;

    Customer(int customerId, String name, String age, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.age = age;
        this.phone = phone;
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
        this.name = name;
    }

    public String getAge() {
        return age;
    }
    
    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
