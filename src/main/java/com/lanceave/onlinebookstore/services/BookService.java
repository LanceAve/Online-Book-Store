package com.lanceave.onlinebookstore.services;

import com.lanceave.onlinebookstore.entities.Book;
import com.lanceave.onlinebookstore.entities.BookList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookList bookList;

    public BookService(BookList bookList) {
        this.bookList = bookList;
    }

    public List<Book> getAllBooks() {
        return bookList.getBooks();
    }


    public Book findByIsbn(String isbn) {
        return bookList.getBooks().stream()
                .filter(b -> b.getBookISBN().equals(isbn))
                .findFirst()
                .orElse(null);
    }
}
