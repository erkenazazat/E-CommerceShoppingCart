package factory.concrete;

import builder.builder.ProductBuilder;
import builder.product.Product;
import factory.creator.ProductFactory;

public class ElectronicsFactory extends ProductFactory {
    @Override
    protected Product createProduct(String id, String name, double price) {
        return new ProductBuilder(id, name, price)
                .category("Electronics")
                .warrantyMonths(12)
                .build();
    }
}
