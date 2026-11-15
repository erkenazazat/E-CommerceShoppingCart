import builder.builder.ProductBuilder;
import builder.director.ProductDirector;
import builder.product.Product;
import factory.concrete.ClothingFactory;
import factory.concrete.ElectronicsFactory;
import factory.creator.ProductFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("1.BUILDER");
        Product phone=new ProductBuilder("P1", "18 Pro Max", 1700)
                .category("Electronics")
                .color("Black")
                .warrantyMonths(12)
                .build();
        System.out.println(phone.getDescription());

        ProductDirector director=new ProductDirector();
        Product gamingLaptop=director.buildGamingLaptop("G1");
        System.out.println(gamingLaptop.getDescription());

        System.out.println("\n2.FACTORY METHOD");
        ProductFactory electronicsFactory=new ElectronicsFactory();
        ProductFactory clothingFactory=new ClothingFactory();
        Product laptop=electronicsFactory.order("L1", "Laptop", 1200);
        Product shirt=clothingFactory.order("S1", "T-Shirt", 25);
    }
}
