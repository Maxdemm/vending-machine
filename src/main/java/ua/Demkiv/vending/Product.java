package ua.Demkiv.vending;

public final class Product {

    private final int id;
    private final String name;
    private final double price;

    public Product( int id, String name, double price ) {
        if (id < 0)
            throw new IllegalArgumentException("id must be positive");
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("name cannot be empty");
        if (price < 0)
            throw new IllegalArgumentException("price must be positive");

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
}
