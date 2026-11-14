package builder.builder;

import builder.product.Product;

public class ProductBuilder {
    private final String id;
    private final String name;
    private final double price;

    private String category="General";
    private String color="Default";
    private String size="Standard";
    private int warrantyMonths=0;

    public ProductBuilder(String id, String name, double price) {
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public ProductBuilder category(String category) {
        this.category=category;
        return this;
    }
    public ProductBuilder color(String color) {
        this.color=color;
        return this;
    }
    public ProductBuilder size(String size) {
        this.size=size;
        return this;
    }
    public ProductBuilder warrantyMonths(int warrantyMonths) {
        this.warrantyMonths=warrantyMonths;
        return this;
    }
    public Product build() {
        if (price<0) {
            throw new IllegalStateException("Price cannot be negative");
        }
        return new Product(id, name, price, category, color, size, warrantyMonths);
    }
}
