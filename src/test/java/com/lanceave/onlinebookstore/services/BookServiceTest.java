package com.lanceave.onlinebookstore.services;

import com.lanceave.onlinebookstore.entities.Book;
import com.lanceave.onlinebookstore.entities.BookList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private BookList bookList;
    private BookService bookService;

    @BeforeEach
    void setup() {
        bookList = new BookList();
        bookService = new BookService(bookList);
    }

    @Test
    void getAllBooks_shouldReturnInitialBooks() {
        List<Book> books = bookService.getAllBooks();

        assertNotNull(books);
        assertTrue(books.size() >= 10); // assuming 10 defaults
    }

    @Test
    void addNewBook_shouldAddToBookList() {
        Book newBook = new Book("Test Book", "Test Author", 25.00);
        bookService.addNewBook(newBook);

        List<Book> books = bookService.getAllBooks();

        assertTrue(books.contains(newBook));
    }

    @Test
    void findByIsbn_shouldReturnCorrectBook() {
        Book newBook = new Book("Unique Title", "Someone", 30.00);
        bookService.addNewBook(newBook);

        String isbn = newBook.getBookISBN(); // retrieve generated ISBN
        Book found = bookService.findByIsbn(isbn);

        assertNotNull(found);
        assertEquals("Unique Title", found.getBookTitle());
    }

    @Test
    void findByIsbn_shouldReturnNullForUnknownIsbn() {
        Book result = bookService.findByIsbn("999999");
        assertNull(result); // assuming this ISBN isn't pre-initialized
    }
}