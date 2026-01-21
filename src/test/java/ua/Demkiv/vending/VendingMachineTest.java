package ua.Demkiv.vending;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    @Test
    void shouldReturnChange() {
        Product apple = new Product(1, "apple", 5);
        Product[] products = {apple};

        VendingMachine vm = new VendingMachine(products);
        vm.insertMoney(7);
        vm.selectProduct(1);

        double change = vm.getChange();
        assertEquals(2, change);
    }

    @Test
    void shouldInsertMoney() {
        Product apple = new Product(1, "apple", 5);
        VendingMachine vm = new VendingMachine(new Product[]{apple});

        double balance = vm.insertMoney(7);
        assertEquals(7, balance);
    }

    @Test
    void shouldReturnProduct() {
        Product apple = new Product(1, "apple", 5);
        VendingMachine vm = new VendingMachine(new Product[]{apple});

        vm.insertMoney(7);
        Product selected = vm.selectProduct(1);

        assertEquals(apple, selected);
    }

    @Test
    void shouldThrowWhenNotEnoughMoney() {
        Product apple = new Product(1, "apple", 5);
        VendingMachine vm = new VendingMachine(new Product[]{apple});
        vm.insertMoney(3);

        try {
            vm.selectProduct(1);
            fail("Expected IllegalArgumentException for insufficient money");
        } catch (IllegalArgumentException e) {
            assertEquals("Money not enough", e.getMessage());
        }
    }

    @Test
    void shouldThrowWhenProductNotFound() {
        Product apple = new Product(1, "apple", 5);
        VendingMachine vm = new VendingMachine(new Product[]{apple});
        vm.insertMoney(10);

        try {
            vm.selectProduct(2); // ID 2 немає
            fail("Expected IllegalArgumentException for product not found");
        } catch (IllegalArgumentException e) {
            assertEquals("Product not found", e.getMessage());
        }
    }

    @Test
    void shouldThrowWhenInsertNonPositiveAmount() {
        VendingMachine vm = new VendingMachine(new Product[]{});

        try {
            vm.insertMoney(0);
            fail("Expected IllegalArgumentException for zero amount");
        } catch (IllegalArgumentException e) {
            assertEquals("Amount must be positive", e.getMessage());
        }

        try {
            vm.insertMoney(-5);
            fail("Expected IllegalArgumentException for negative amount");
        } catch (IllegalArgumentException e) {
            assertEquals("Amount must be positive", e.getMessage());
        }
    }
}
