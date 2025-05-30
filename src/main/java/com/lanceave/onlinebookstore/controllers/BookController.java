package com.lanceave.onlinebookstore.controllers;

import com.lanceave.onlinebookstore.entities.Book;
import com.lanceave.onlinebookstore.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Available Books Page
    @GetMapping
    public String showAvailableBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("newBook", new Book("", "", 0.0)); // empty book for the form
        return "available_books";
    }

    // Shopping Page
    @GetMapping("/shopping")
    public String showShoppingBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "shopping_books";
    }

    // Add a new book to the list
    @PostMapping("/add")
    public String addBook(@ModelAttribute("newBook") Book newBook) {
        newBook.setBookISBN(generateRandomISBN());
        bookService.addNewBook(newBook);
        return "redirect:/books"; // prevent form re-submission
    }

    private String generateRandomISBN() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }
}
