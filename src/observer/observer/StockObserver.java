package observer.observer;

public interface StockObserver {
    void update(String productId, int stock, double price);
}