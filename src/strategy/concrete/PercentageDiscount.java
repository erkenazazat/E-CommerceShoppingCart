package strategy.concrete;

import strategy.strategy.DiscountStrategy;

public class PercentageDiscount implements DiscountStrategy {
    private final double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double apply(double subtotal, int itemCount) {
        return subtotal - subtotal * percent / 100;
    }

    @Override
    public String getName() {
        return percent + "% discount";
    }
}