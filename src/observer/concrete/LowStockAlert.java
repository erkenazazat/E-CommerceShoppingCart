package observer.concrete;

import builder.product.Product;
import observer.observer.InventoryObserver;

public class LowStockAlert implements InventoryObserver {
    private final int threshold;

    public LowStockAlert(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void onStockChanged(Product product, int oldQty, int newQty) {
        if (newQty <= threshold && newQty < oldQty) {
            System.out.printf("[Admin] Low stock for '%s': %d pcs left%n", product.getName(), newQty);
        }
    }

    @Override
    public void onPriceChanged(Product product, double oldPrice, double newPrice) {
        // admin is not interested in price changes
    }
}