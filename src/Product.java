public class Product {
    private int serialNumberId;
    private String name;
    private String brand;
    private double price;
    private int stock;
    private String description;
    private int sellerId;
    private int adminId;

    public Product(int adminId, String brand, String description, String name, double price, int sellerId, int serialNumberId, int stock) {
        this.adminId = adminId;
        this.brand = brand;
        this.description = description;
        this.name = name;
        this.price = price;
        this.sellerId = sellerId;
        this.serialNumberId = serialNumberId;
        this.stock = stock;
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

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

}
