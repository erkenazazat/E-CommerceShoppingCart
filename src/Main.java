import builder.builder.ProductBuilder;
import builder.director.ProductDirector;
import builder.product.Product;
import decorator.component.Purchasable;
import decorator.concrete.ExtendedWarranty;
import decorator.concrete.GiftWrap;
import factory.concrete.ClothingFactory;
import factory.concrete.ElectronicsFactory;
import factory.creator.ProductFactory;
import strategy.concrete.BulkDiscount;
import strategy.concrete.PercentageDiscount;
import strategy.context.ShoppingCart;

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

        System.out.println("\n3.DECORATOR");
        Purchasable specialPhone = new ExtendedWarranty(new GiftWrap(phone));
        System.out.println(specialPhone.getDescription());
        System.out.println("Price with extras: " + specialPhone.getPrice());

        System.out.println("\n4.STRATEGY");
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(specialPhone);
        cart.addItem(laptop);
        cart.addItem(shirt);
        System.out.println("Subtotal: " + cart.getSubtotal());

        cart.setDiscountStrategy(new PercentageDiscount(20));
        System.out.println(cart.getDiscountName() + " -> " + cart.getTotal());

        cart.setDiscountStrategy(new BulkDiscount());
        System.out.println(cart.getDiscountName() + " -> " + cart.getTotal());

        System.out.println("\n5.OBSERVER");
        Inventory inventory = new Inventory();
        inventory.subscribe(new CustomerNotifier("Alice"));
        inventory.subscribe(new AdminDashboard());
        inventory.addProduct(phone, 5);
        inventory.addProduct(laptop, 2);
        inventory.addProduct(shirt, 10);
        System.out.println("Changing price of P1 to 750...");
        inventory.changePrice("P1", 750);

        System.out.println("\n6.FACADE");
        CheckoutFacade checkout = new CheckoutFacade(inventory, new PaymentService());
        checkout.checkout(cart);
    }
}
