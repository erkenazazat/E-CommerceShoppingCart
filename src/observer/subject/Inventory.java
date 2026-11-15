package observer.subject;

import builder.product.Product;
import observer.observer.StockObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products = new HashMap<>();
    private final Map<String, Integer> stock = new HashMap<>();
    private final List<StockObserver> observers = new ArrayList<>();

    public void subscribe(StockObserver observer) {
        observers.add(observer);
    }

    public void unsubscribe(StockObserver observer) {
        observers.remove(observer);
    }

    public void addProduct(Product product, int quantity) {
        products.put(product.getId(), product);
        stock.put(product.getId(), quantity);
    }

    public int getStock(String productId) {
        return stock.getOrDefault(productId, 0);
    }

    public void changePrice(String productId, double newPrice) {
        Product product = products.get(productId);
        product.setPrice(newPrice);
        notifyObservers(productId);
    }

    public boolean reduceStock(String productId, int quantity) {
        int current = getStock(productId);
        if (current < quantity) {
            return false;
        }
        stock.put(productId, current - quantity);
        notifyObservers(productId);
        return true;
    }

    private void notifyObservers(String productId) {
        double price = products.get(productId).getPrice();
        int currentStock = stock.get(productId);
        for (StockObserver observer : observers) {
            observer.update(productId, currentStock, price);
        }
    }
}