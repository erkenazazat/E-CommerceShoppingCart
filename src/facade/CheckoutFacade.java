package facade;

import decorator.component.Purchasable;
import facade.subsystem.EmailService;
import facade.subsystem.OrderService;
import facade.subsystem.PaymentService;
import observer.subject.Inventory;
import strategy.context.ShoppingCart;

import java.util.LinkedHashMap;
import java.util.Map;

public class CheckoutFacade {
    private final Inventory inventory;
    private final PaymentService payment = new PaymentService();
    private final OrderService orders = new OrderService();
    private final EmailService email = new EmailService();

    public CheckoutFacade(Inventory inventory) {
        this.inventory = inventory;
    }

    public int checkout(String customer, ShoppingCart cart) {
        if (cart.getItems().isEmpty()) {
            System.out.println("[Checkout] Cart is empty");
            return -1;
        }

        // 1. count how many pieces of each product are needed (decorated items share the product id)
        Map<String, Integer> needed = new LinkedHashMap<>();
        for (Purchasable item : cart.getItems()) {
            needed.merge(item.getId(), 1, Integer::sum);
        }

        // 2. check stock
        for (Map.Entry<String, Integer> e : needed.entrySet()) {
            if (inventory.getStock(e.getKey()) < e.getValue()) {
                System.out.println("[Checkout] Not enough stock for: "
                        + inventory.getProduct(e.getKey()).getName());
                return -1;
            }
        }

        // 3. total with discount (Strategy inside the cart)
        double total = cart.getTotal();
        System.out.printf("[Checkout] Subtotal %.2f, discount: %s, to pay: %.2f%n",
                cart.getSubtotal(), cart.getDiscountName(), total);

        // 4. payment
        if (!payment.charge(customer, total)) {
            return -1;
        }

        // 5. reduce stock -> this triggers the Observers
        for (Map.Entry<String, Integer> e : needed.entrySet()) {
            inventory.updateStock(e.getKey(), inventory.getStock(e.getKey()) - e.getValue());
        }

        // 6. order and confirmation email
        int orderId = orders.createOrder(customer, total);
        email.sendConfirmation(customer, orderId);
        return orderId;
    }
}