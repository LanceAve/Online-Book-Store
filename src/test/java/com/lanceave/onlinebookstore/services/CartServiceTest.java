package com.lanceave.onlinebookstore.services;

import com.lanceave.onlinebookstore.entities.Book;
import com.lanceave.onlinebookstore.entities.BookCartList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartServiceTest {

    private final CartService cartService = new CartService();

    @Test
    void addBookToCart_shouldIncreaseCartSize() {
        BookCartList cart = new BookCartList();
        Book book = new Book("Title", "Author", 19.99);

        cartService.addBookToCart(cart, book);

        assertEquals(1, cart.getCartSize());
        assertEquals(book, cart.getCartBooks().get(0));
    }

    @Test
    void calculateSubtotal_shouldReturnCorrectSum() {
        BookCartList cart = new BookCartList();
        cart.addToCart(new Book("A", "X", 10.0));
        cart.addToCart(new Book("B", "Y", 20.0));

        double subtotal = cartService.calculateSubtotal(cart);

        assertEquals(30.0, subtotal, 0.001);
    }

    @Test
    void calculateTotal_shouldIncludeTax() {
        BookCartList cart = new BookCartList();
        cart.addToCart(new Book("A", "X", 100.0)); // expect total ~113.0

        double subtotal = cartService.calculateSubtotal(cart);
        double total = cartService.calculateTotal(subtotal);

        assertEquals(113.0, total, 0.001);
    }
}