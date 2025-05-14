package com.lanceave.onlinebookstore.entities;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class BookList {
    private final List<Book> books = new ArrayList<>();

    public BookList() {
        // Initialize with 10 default books
        books.add(new Book("Clean Code", "Robert C. Martin", 45.99));
        books.add(new Book("Effective Java", "Joshua Bloch", 39.99));
        books.add(new Book("Spring in Action", "Craig Walls", 49.99));
        books.add(new Book("Head First Design Patterns", "Eric Freeman", 42.99));
        books.add(new Book("The Pragmatic Programmer", "Andrew Hunt", 37.99));
        books.add(new Book("Java: The Complete Reference", "Herbert Schildt", 50.99));
        books.add(new Book("Design Patterns", "Erich Gamma", 48.99));
        books.add(new Book("You Don't Know JS", "Kyle Simpson", 29.99));
        books.add(new Book("Refactoring", "Martin Fowler", 46.99));
        books.add(new Book("Domain-Driven Design", "Eric Evans", 52.99));
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
