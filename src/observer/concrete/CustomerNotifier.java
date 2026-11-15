package observer.concrete;

import observer.observer.StockObserver;

public class CustomerNotifier implements StockObserver {
    private final String customerName;

    public CustomerNotifier(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void update(String productId, int stock, double price) {
        System.out.println("[Customer " + customerName + "] Product " + productId
                + " updated: price = " + price + ", in stock = " + stock);
    }
}