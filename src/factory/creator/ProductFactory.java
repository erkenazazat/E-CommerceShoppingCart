package factory.creator;

import builder.product.Product;

public abstract class ProductFactory {
    protected abstract Product createProduct(String id, String name, double price);

    public Product order(String id, String name, double price) {
        Product product = createProduct(id, name, price);
        System.out.println("Created: "+product.getDescription());
        return product;
    }
}
