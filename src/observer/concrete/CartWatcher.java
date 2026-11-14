package observer.concrete;

import builder.product.Product;
import decorator.component.Purchasable;
import observer.observer.InventoryObserver;
import strategy.context.ShoppingCart;

public class CartWatcher implements InventoryObserver {
    private final ShoppingCart cart;

    public CartWatcher(ShoppingCart cart) {
        this.cart = cart;
    }

    private int countInCart(String productId) {
        int count = 0;
        for (Purchasable item : cart.getItems()) {
            if (item.getId().equals(productId)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void onPriceChanged(Product product, double oldPrice, double newPrice) {
        if (countInCart(product.getId()) > 0) {
            System.out.printf("[Cart] Price of '%s' changed: %.2f -> %.2f. Cart total: %.2f (%s)%n",
                    product.getName(), oldPrice, newPrice, cart.getTotal(), cart.getDiscountName());
        }
    }

    @Override
    public void onStockChanged(Product product, int oldQty, int newQty) {
        int inCart = countInCart(product.getId());
        if (inCart > newQty) {
            System.out.printf("[Cart] Warning: only %d of '%s' in stock, but %d in cart%n",
                    newQty, product.getName(), inCart);
        }
    }
}