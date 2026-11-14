package decorator.concrete;

import decorator.base.PurchasableDecorator;
import decorator.component.Purchasable;

public class ExtendedWarranty extends PurchasableDecorator {
    private static final double WARRANTY_PRICE = 50;

    public ExtendedWarranty(Purchasable wrapped) {
        super(wrapped);
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " + Extended warranty";
    }

    @Override
    public double getPrice() {
        return wrapped.getPrice() + WARRANTY_PRICE;
    }
}