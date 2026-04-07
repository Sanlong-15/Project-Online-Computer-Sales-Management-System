public class Seller {
    private int sellerId;
    private Product product;
    private String name;
    private String age;
    private String phone;

    Seller(int sellerId, Product product, String name, String age, String phone) {
        this.sellerId = sellerId;
        this.product = product;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
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
