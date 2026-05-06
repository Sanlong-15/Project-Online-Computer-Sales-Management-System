package interfaces;

import model.Product;

public interface Manageable {
    void addItem(Product product, int quantity);
    void removeItem(Product product);
}
