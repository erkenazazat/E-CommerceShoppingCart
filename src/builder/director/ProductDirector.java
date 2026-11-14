package builder.director;

import builder.builder.ProductBuilder;
import builder.product.Product;

public class ProductDirector {
    public Product buildGamingLaptop(String id) {
        return new ProductBuilder(id, "Gaming Laptop", 1800)
                .category("Electronics")
                .color("Black")
                .size("17 inch")
                .warrantyMonths(24)
                .build();
    }
    public Product buildBasicTShirt(String id) {
        return new ProductBuilder(id, "Basic T-Shirt", 15)
                .category("Clothing")
                .color("White")
                .size("M")
                .build();
    }
}
