package builder.product;

import decorator.component.Purchasable;

public class Product implements Purchasable {
    private final String id;
    private final String name;
    private final String category;
    private final String color;
    private final String size;
    private final int warrantyMonths;
    private double price;

    public Product(String id, String name, double price, String category, String color, String size, int warrantyMonths) {
        this.id=id;
        this.name=name;
        this.price=price;
        this.category=category;
        this.color=color;
        this.size=size;
        this.warrantyMonths=warrantyMonths;
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public String getDescription() {
        return name+" ("+category+", "+color+", "+size+", warranty: "+warrantyMonths+" months)";
    }
    @Override
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price=price;
    }
    public String getName() {
        return  name;
    }
}
