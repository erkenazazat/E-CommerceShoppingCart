package strategy.context;

import decorator.component.Purchasable;
import strategy.concrete.NoDiscount;
import strategy.strategy.DiscountStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Purchasable> items = new ArrayList<>();
    private DiscountStrategy discountStrategy = new NoDiscount();

    public void addItem(Purchasable item) {
        items.add(item);
    }

    public List<Purchasable> getItems() {
        return new ArrayList<>(items);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public String getDiscountName() {
        return discountStrategy.getName();
    }

    public double getSubtotal() {
        double sum = 0;
        for (Purchasable item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    public double getTotal() {
        return discountStrategy.apply(getSubtotal(), items.size());
    }
}