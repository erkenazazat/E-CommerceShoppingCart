package strategy.concrete;

import strategy.strategy.DiscountStrategy;

public class BulkDiscount implements DiscountStrategy {
    private static final int MIN_ITEMS = 3;
    private static final double BULK_PERCENT = 10;

    @Override
    public double apply(double subtotal, int itemCount) {
        if (itemCount >= MIN_ITEMS) {
            return subtotal - subtotal * BULK_PERCENT / 100;
        }
        return subtotal;
    }

    @Override
    public String getName() {
        return "Bulk discount (" + MIN_ITEMS + "+ items = " + BULK_PERCENT + "%)";
    }
}