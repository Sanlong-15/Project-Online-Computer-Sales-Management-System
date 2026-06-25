package interfaces;

@FunctionalInterface
public interface Calculatable {

    double calculateTotal();

    default boolean isZero() {
        return calculateTotal() == 0;
    }
}
