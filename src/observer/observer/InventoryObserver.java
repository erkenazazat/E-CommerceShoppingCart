package observer.observer;

import builder.product.Product;

public interface InventoryObserver {
    void onStockChanged(Product product, int oldQty, int newQty);
    void onPriceChanged(Product product, double oldPrice, double newPrice);
}