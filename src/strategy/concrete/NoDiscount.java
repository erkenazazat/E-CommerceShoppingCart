package strategy.concrete;

import strategy.strategy.DiscountStrategy;

public class NoDiscount implements DiscountStrategy {

    @Override
    public double apply(double subtotal, int itemCount) {
        return subtotal;
    }

    @Override
    public String getName() {
        return "No discount";
    }
}