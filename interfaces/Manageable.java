package interfaces;

import model.Product;

public interface Manageable {

    boolean addItem(Product product, int quantity);
    boolean removeItemByProductId(int productId);
}