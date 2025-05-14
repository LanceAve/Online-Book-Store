package com.lanceave.onlinebookstore.services;

import static org.junit.jupiter.api.Assertions.*;
import com.lanceave.onlinebookstore.entities.Book;
import com.lanceave.onlinebookstore.entities.BookCartList;
import org.junit.jupiter.api.Test;

class CheckoutServiceTest {

    private final CartService cartService = new CartService();
    private final CheckoutService checkoutService = new CheckoutService(cartService);

    @Test
    void getSubtotal_shouldReturnExpectedValue() {
        BookCartList cart = new BookCartList();
        cart.addToCart(new Book("A", "X", 15.0));
        cart.addToCart(new Book("B", "Y", 25.0));

        double result = checkoutService.getSubtotal(cart);
        assertEquals(40.0, result, 0.001);
    }

    @Test
    void getTax_shouldReturnThirteenPercentOfSubtotal() {
        BookCartList cart = new BookCartList();
        cart.addToCart(new Book("A", "X", 100.0));

        double tax = checkoutService.getTax(cart);
        assertEquals(13.0, tax, 0.001);
    }

    @Test
    void getTotal_shouldIncludeTaxInFinalAmount() {
        BookCartList cart = new BookCartList();
        cart.addToCart(new Book("A", "X", 100.0));

        double total = checkoutService.getTotal(cart);
        assertEquals(113.0, total, 0.001);
    }
}