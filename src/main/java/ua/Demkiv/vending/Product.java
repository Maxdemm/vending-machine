package ua.Demkiv.vending;

/**
 * Represents a product in the vending machine.
 * Immutable class with an ID, name, and price.
 */
public final class Product {

    private final int id;
    private final String name;
    private final double price;

    /**
     * Constructs a Product with the given id, name, and price.
     *
     * @param id    positive identifier of the product
     * @param name  non-null, non-blank name of the product
     * @param price non-negative price of the product
     * @throws IllegalArgumentException if id < 0, name is null/blank, or price < 0
     */
    public Product(int id, String name, double price) {
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

    /**
     * Returns the product ID.
     *
     * @return product ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the product name.
     *
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product price.
     *
     * @return product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns a string representation of the product.
     *
     * @return string with id, name, and price
     */
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }
}
