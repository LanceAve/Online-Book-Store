package com.lanceave.onlinebookstore.controllers;

import com.lanceave.onlinebookstore.entities.Book;
import com.lanceave.onlinebookstore.entities.BookCartList;
import com.lanceave.onlinebookstore.services.BookService;
import com.lanceave.onlinebookstore.services.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final BookService bookService;
    private final CartService cartService;

    public CartController(BookService bookService, CartService cartService) {
        this.bookService = bookService;
        this.cartService = cartService;
    }

    @PostMapping("/add/{isbn}")
    public String addToCart(@PathVariable("isbn") String isbn, HttpSession session) {
        Book book = bookService.findByIsbn(isbn);
        if (book != null) {
            BookCartList cart = getOrCreateCart(session);
            cartService.addBookToCart(cart, book);
        }
        return "redirect:/books/shopping";
    }

