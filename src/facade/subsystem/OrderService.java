package facade.subsystem;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderService {
    private final AtomicInteger counter = new AtomicInteger(1000);

    public int createOrder(String customer, double total) {
        int orderId = counter.incrementAndGet();
        System.out.printf("[Order] Order #%d created for %s, total %.2f%n", orderId, customer, total);
        return orderId;
    }
}