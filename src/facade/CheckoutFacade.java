package facade;

import decorator.component.Purchasable;
import facade.subsystem.PaymentService;
import observer.subject.Inventory;
import strategy.context.ShoppingCart;

public class CheckoutFacade {
    private final Inventory inventory;
    private final PaymentService paymentService;

    public CheckoutFacade(Inventory inventory, PaymentService paymentService) {
        this.inventory = inventory;
        this.paymentService = paymentService;
    }

    // one simple method hides: stock check, payment, stock update
    public boolean checkout(ShoppingCart cart) {
        for (Purchasable item : cart.getItems()) {
            if (inventory.getStock(item.getId()) < 1) {
                System.out.println("Out of stock: " + item.getId());
                return false;
            }
        }

        if (!paymentService.pay(cart.getTotal())) {
            System.out.println("Payment failed");
            return false;
        }

        for (Purchasable item : cart.getItems()) {
            inventory.reduceStock(item.getId(), 1);
        }
        System.out.println("Order completed. Total: " + cart.getTotal());
        return true;
    }
}