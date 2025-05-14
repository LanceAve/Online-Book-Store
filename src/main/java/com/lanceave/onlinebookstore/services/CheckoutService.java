package com.lanceave.onlinebookstore.services;

import com.lanceave.onlinebookstore.entities.BookCartList;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {

    private final CartService cartService;

    public CheckoutService(CartService cartService) {
        this.cartService = cartService;
    }

    public double getSubtotal(BookCartList cart) {
        return cartService.calculateSubtotal(cart);
    }

    public double getTax(BookCartList cart) {
        double subtotal = cartService.calculateSubtotal(cart);
        return cartService.calculateTax(subtotal);
    }

    public double getTotal(BookCartList cart) {
        double subtotal = cartService.calculateSubtotal(cart);
        return cartService.calculateTotal(subtotal);
    }
}