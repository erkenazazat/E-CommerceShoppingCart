package decorator.base;

import decorator.component.Purchasable;

public abstract class PurchasableDecorator implements Purchasable {
    protected final Purchasable wrapped;

    public PurchasableDecorator(Purchasable wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public String getId() {
        return wrapped.getId();
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription();
    }

    @Override
    public double getPrice() {
        return wrapped.getPrice();
    }
}