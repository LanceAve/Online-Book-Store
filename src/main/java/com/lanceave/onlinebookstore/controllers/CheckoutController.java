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

