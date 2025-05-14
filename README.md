# Bookstore Web App

A minimalist bookstore inventory and shopping cart system built with Spring Boot, Thymeleaf, and Java (with honorary guest: JavaScript).

## Features

-  View available books
-  Add books to cart
-  Checkout with subtotal, tax, and total calculation
-  Persistent cart count via server sync
-  Clean UI with responsive design

## Technologies

- Java 21
- Spring Boot
- Thymeleaf
- HTML / CSS/ JavaScript
- Gradle

## How to Run

```bash
./gradlew bootRun
```
Then open: http://localhost:8080

## Demo

[![Watch Demo](images/demo-preview.png)](demo/bookstore-demo.mp4)

## To-Do

- Add user authentication (somehow...)
- Hook up database (SQLite/PostgreSQL)
- Add book search/filter functionality

## Experimental Frontend (Next.js + TypeScript)
A seperate 'nextjs-frontend' branch which contains a fully client-rendered version fo the UI via the use of React + Next.js. Currently a work in progress.

Branch: [`nextjs-frontend`](https://github.com/LanceAve/OnlineBookStore/tree/nextjs-frontend)