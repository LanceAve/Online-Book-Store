package com.lanceave.onlinebookstore.services;

import com.lanceave.onlinebookstore.entities.Book;
import com.lanceave.onlinebookstore.entities.BookCartList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    public void addBookToCart(BookCartList cart, Book book) {
        cart.addToCart(book);
    }

    public List<Book> getCartItems(BookCartList cart) {
        return cart.getCartBooks();
    }

    public int getItemCount(BookCartList cart) {
        return cart.getCartSize();
    }

    public double calculateSubtotal(BookCartList cart) {
        return cart.getCartBooks().stream()
                .mapToDouble(Book::getBookPrice)
                .sum();
    }

    public double calculateTax(double subtotal) {
        return subtotal * 0.13;
    }

    public double calculateTotal(double subtotal) {
        return subtotal + calculateTax(subtotal);
    }
}