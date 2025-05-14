package com.lanceave.onlinebookstore.entities;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class BookCartList {
    private final List<Book> cartBooks = new ArrayList<>();

    public void addToCart(Book book) {
        cartBooks.add(book);
    }

    public double getSubtotal() {
        return cartBooks.stream().mapToDouble(Book::getBookPrice).sum();
    }

    public double getSalesTax(double taxRate) {
        return getSubtotal() * taxRate;
    }

    public double getTotal(double taxRate) {
        return getSubtotal() + getSalesTax(taxRate);
    }

    public int getCartSize() {
        return cartBooks.size();
    }
}
