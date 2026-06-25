package interfaces;

@FunctionalInterface
public interface BundleCalculator {
    double calculate(double pricePerItem, int quantity, double discount);
}
