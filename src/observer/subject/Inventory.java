package observer.subject;

import builder.product.Product;
import observer.observer.InventoryObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products = new HashMap<>();
    private final Map<String, Integer> stock = new HashMap<>();
    private final List<InventoryObserver> observers = new ArrayList<>();

    public void attach(InventoryObserver observer) {
        observers.add(observer);
    }

    public void detach(InventoryObserver observer) {
        observers.remove(observer);
    }

    public void addProduct(Product product, int qty) {
        products.put(product.getId(), product);
        stock.put(product.getId(), qty);
    }

    public int getStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }

    public void updateStock(String productId, int newQty) {
        Product product = products.get(productId);
        int oldQty = stock.get(productId);
        stock.put(productId, newQty);
        for (InventoryObserver o : new ArrayList<>(observers)) {
            o.onStockChanged(product, oldQty, newQty);
        }
    }

    public void updatePrice(String productId, double newPrice) {
        Product product = products.get(productId);
        double oldPrice = product.getPrice();
        product.setPrice(newPrice);
        for (InventoryObserver o : new ArrayList<>(observers)) {
            o.onPriceChanged(product, oldPrice, newPrice);
        }
    }
}