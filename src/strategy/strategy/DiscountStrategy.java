package strategy.strategy;

public interface DiscountStrategy {
    double apply(double subtotal, int itemCount);

    String getName();
}