package observer.concrete;

import observer.observer.StockObserver;

public class AdminDashboard implements StockObserver {
    private static final int LOW_STOCK_LIMIT = 3;

    @Override
    public void update(String productId, int stock, double price) {
        if (stock < LOW_STOCK_LIMIT) {
            System.out.println("[Admin] WARNING: low stock for " + productId
                    + " (" + stock + " left)");
        }
    }
}