package ua.Demkiv.vending;

import java.util.Arrays;

public class VendingMachine {

    private Product [] products;
    private double balance;

    public VendingMachine(Product [] products)
    {
        this.products = Arrays.copyOf(products, products.length);
    }

    public String[] getProductsNames() {
        String[] productsNames = new String[this.products.length];
        for (int i = 0; i < this.products.length; i++)
            productsNames[i] = products[i].getName();

        return productsNames;
    }

    public double insertMoney(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Amount must be positive");

        balance += amount;
        return balance;
    }

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

    public double getChange() {
        double change = balance;
        balance = 0;
        return change;
    }


}
