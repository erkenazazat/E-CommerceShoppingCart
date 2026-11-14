package observer.concrete;

import builder.product.Product;
import observer.observer.InventoryObserver;

import java.util.HashSet;
import java.util.Set;

public class CustomerNotifier implements InventoryObserver {
    private final String customer;
    private final Set<String> wishlist = new HashSet<>();

    public CustomerNotifier(String customer) {
        this.customer = customer;
    }

    public void watch(String productId) {
        wishlist.add(productId);
    }

    @Override
    public void onStockChanged(Product product, int oldQty, int newQty) {
        if (wishlist.contains(product.getId()) && oldQty == 0 && newQty > 0) {
            System.out.printf("[Notify -> %s] '%s' is back in stock (%d pcs)%n",
                    customer, product.getName(), newQty);
        }
    }

    @Override
    public void onPriceChanged(Product product, double oldPrice, double newPrice) {
        if (wishlist.contains(product.getId()) && newPrice < oldPrice) {
            System.out.printf("[Notify -> %s] Price of '%s' dropped: %.2f -> %.2f%n",
                    customer, product.getName(), oldPrice, newPrice);
        }
    }
}