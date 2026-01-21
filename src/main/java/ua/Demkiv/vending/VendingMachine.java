package ua.Demkiv.vending;

import java.util.Arrays;

/**
 * Represents a simple vending machine that can store products,
 * accept money, dispense products, and return change.
 */
public class VendingMachine {

    private Product[] products;
    private double balance;

    /**
     * Creates a vending machine with the given products.
     *
     * @param products array of products to be available in the machine
     */
    public VendingMachine(Product[] products) {
        this.products = Arrays.copyOf(products, products.length);
    }

    /**
     * Returns the names of all products in the vending machine.
     *
     * @return array of product names
     */
    public String[] getProductsNames() {
        String[] productsNames = new String[this.products.length];
        for (int i = 0; i < this.products.length; i++)
            productsNames[i] = products[i].getName();

        return productsNames;
    }

    /**
     * Inserts money into the vending machine.
     *
     * @param amount positive amount to insert
     * @return current balance after insertion
     * @throws IllegalArgumentException if amount is not positive
     */
    public double insertMoney(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");

        balance += amount;
        return balance;
    }

    /**
     * Selects a product by its ID.
     *
     * @param id product identifier
     * @return the selected Product
     * @throws IllegalArgumentException if product not found or balance is insufficient
     */
    public Product selectProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                if (balance >= product.getPrice()) {
                    balance -= product.getPrice();
                    return product;
                } else throw new IllegalArgumentException("Money not enough");
            }
        }
        throw new IllegalArgumentException("Product not found");
    }

    /**
     * Returns the remaining balance (change) and resets balance to zero.
     *
     * @return remaining balance
     */
    public double getChange() {
        double change = balance;
        balance = 0;
        return change;
    }
}
