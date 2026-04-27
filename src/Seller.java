public class Seller {
    private int sellerId;
    private Product product;
    private String name;
    private String age;
    private String phone;

    Seller(int sellerId, Product product, String name, String age, String phone) {
        setSellerId(sellerId);
        setProduct(product);
        setName(name);
        setAge(age);
        setPhone(phone);
    }

    public int getSellerId() {
        return sellerId;
    }

    private void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
}