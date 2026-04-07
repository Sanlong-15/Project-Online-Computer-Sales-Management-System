public class OnlineComputerSaleManagementSystemMain {
    public static void main(String[] args) {


        Product p1 = new Product(1, "Laptop", "Dell", 1000.0, 10, "High-performance laptop");

        System.out.println("Product ID: " + p1.getSerialNumberId());
        System.out.println("Product Name: " + p1.getName());
        System.out.println("Product Price: " + p1.getPrice());
        System.out.println("Product Stock: " + p1.getStock());
        System.out.println("Product Description: " + p1.getDescription());

        Customer c1 = new Customer(1, "John Doe", "30", "123-456-7890");

        System.out.println("Customer ID: " + c1.getCustomerId());
        System.out.println("Customer Name: " + c1.getName());
        System.out.println("Customer Age: " + c1.getAge());
        System.out.println("Customer Phone: " + c1.getPhone());

    }

}