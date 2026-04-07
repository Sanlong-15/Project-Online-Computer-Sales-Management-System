public class Product  {
    private int serialNumberId;
    private String name;
    private String brand;
    private double price;
    private int stock;
    private String description;

    Product(int serialNumberId, String name, String brand, double price, int stock, String description) {
        this.serialNumberId = serialNumberId;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public int getSerialNumberId() {
        return serialNumberId;
    }

    public void setSerialNumberId(int serialNumberId) {
        this.serialNumberId = serialNumberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
