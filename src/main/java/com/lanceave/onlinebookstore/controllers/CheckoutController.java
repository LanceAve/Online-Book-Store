package com.lanceave.onlinebookstore.controllers;

import com.lanceave.onlinebookstore.entities.BookCartList;
import com.lanceave.onlinebookstore.services.CheckoutService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final DecimalFormat df = new DecimalFormat("#0.00");

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping
    public String showCheckout(Model model, HttpSession session) {
        BookCartList cart = getOrCreateCart(session);

        double subtotal = checkoutService.getSubtotal(cart);
        double tax = checkoutService.getTax(cart);
        double total = checkoutService.getTotal(cart);

        model.addAttribute("cartBooks", cart.getCartBooks());
        model.addAttribute("subtotal", df.format(subtotal));
        model.addAttribute("salesTax", df.format(tax));
        model.addAttribute("total", df.format(total));

        return "checkout";
    }

    private BookCartList getOrCreateCart(HttpSession session) {
        BookCartList cart = (BookCartList) session.getAttribute("cart");
        if (cart == null) {
            cart = new BookCartList();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
}