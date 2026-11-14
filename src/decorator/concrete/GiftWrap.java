package decorator.concrete;

import decorator.base.PurchasableDecorator;
import decorator.component.Purchasable;

public class GiftWrap extends PurchasableDecorator {
    private static final double WRAP_PRICE = 5;

    public GiftWrap(Purchasable wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + Gift wrap";
    }

    @Override
    public double getPrice() {
        return wrapped.getPrice() + WRAP_PRICE;
    }
}