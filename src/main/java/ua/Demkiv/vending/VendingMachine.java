package ua.Demkiv.vending;

import java.util.Arrays;

public class VendingMachine {

    private Product [] products;
    private double balance;

    public VendingMachine(Product [] products, int balance)
    {
        this.products = Arrays.copyOf(products, products.length);
        this.balance = balance;
    }

    public String[] getProductsNames() {
        String[] productsNames = new String[this.products.length];
        for (int i = 0; i < this.products.length; i++)
            productsNames[i] = products[i].getName();

        return productsNames;
    }

    public void insertMoney(double amount) {
        balance += amount;
    }

    public Product selectProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                if (balance >= product.getPrice()) {
                    balance -= product.getPrice();
                    return product;
                } else throw new IllegalArgumentException("Money not enough");
            } else {
                throw new IllegalArgumentException("Product with this id not found");
            }
        }
        return null;
    }

    public double getChange() {
        double change = balance;
        balance = 0;
        return change;
    }


}
