package ua.Demkiv.vending;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldCreateProduct() {
        Product apple = new Product(1, "apple", 5.0);

        assertEquals(1, apple.getId());
        assertEquals("apple", apple.getName());
        assertEquals(5.0, apple.getPrice());
        assertEquals("Product{id=1, name=apple, price=5.0}", apple.toString());
    }

    @Test
    void shouldThrowWhenIdNegative() {
        try {
            new Product(-1, "apple", 5.0);
            fail("Expected IllegalArgumentException for negative id");
        } catch (IllegalArgumentException e) {
            assertEquals("id must be positive", e.getMessage());
        }
    }

    @Test
    void shouldThrowWhenNameIsNullOrBlank() {
        try {
            new Product(1, null, 5.0);
            fail("Expected IllegalArgumentException for null name");
        } catch (IllegalArgumentException e) {
            assertEquals("name cannot be empty", e.getMessage());
        }

        try {
            new Product(1, "   ", 5.0);
            fail("Expected IllegalArgumentException for blank name");
        } catch (IllegalArgumentException e) {
            assertEquals("name cannot be empty", e.getMessage());
        }
    }

    @Test
    void shouldThrowWhenPriceNegative() {
        try {
            new Product(1, "apple", -5.0);
            fail("Expected IllegalArgumentException for negative price");
        } catch (IllegalArgumentException e) {
            assertEquals("price must be positive", e.getMessage());
        }
    }
}

