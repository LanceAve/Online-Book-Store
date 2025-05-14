package com.lanceave.onlinebookstore.entities;

import lombok.Getter;
import lombok.Setter;
import java.util.Random;

@Getter
@Setter
public class Book {
    private String bookISBN;
    private String bookTitle;
    private String bookAuthor;
    private double bookPrice;

    public Book(String bookTitle, String bookAuthor, double bookPrice) {
        this.bookISBN = generateBookISBN();
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }

    private String generateBookISBN() {
        return String.valueOf(100000 + new Random().nextInt(900000)); // Generates a random 6-digit number
    }
}
