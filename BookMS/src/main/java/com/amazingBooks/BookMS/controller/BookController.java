package com.amazingBooks.BookMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;

@RequestMapping("/Books")
public class BookController {

@GetMapping()
    String testBooksController(){

    return "Hello I am Book Contoller";
}

}
