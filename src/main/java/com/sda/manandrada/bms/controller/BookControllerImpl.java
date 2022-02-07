package com.sda.manandrada.bms.controller;

import com.sda.manandrada.bms.service.BookService;
import com.sda.manandrada.bms.service.BookServiceImpl;
import com.sda.manandrada.bms.service.exceptions.AuthorNotFoundExceptions;

import java.util.Scanner;

public class BookControllerImpl implements BookController {

    private static final Scanner SCANNER = new Scanner(System.in);//constanta

    //private encapsularea, sa pot accesa cu get si set
    private BookService bookService;//BookService aici interfata


    public BookControllerImpl() {
        bookService = new BookServiceImpl();//BookService clasa

    }

    public void createBook() {
        System.out.println("Create book: ");
        System.out.println("Please insert ISBN");
        String isbn = SCANNER.nextLine();
        System.out.println("Please insert TITTLE");
        String tittle = SCANNER.nextLine();
        System.out.println("Please insert DESCRIPTION");
        String description = SCANNER.nextLine();

        bookService.createBook(isbn, tittle, description);
    }

    @Override
    public void createBookWithAuthor() {
        System.out.println("Create book: ");
        System.out.println("Please insert ISBN");
        String isbn = SCANNER.nextLine();
        System.out.println("Please insert TITTLE");
        String tittle = SCANNER.nextLine();
        System.out.println("Please insert DESCRIPTION");
        String description = SCANNER.nextLine();
        System.out.println("Please insert author id");
        Integer authorId = SCANNER.nextInt();

        try {
            bookService.createBook(isbn, tittle, description, authorId);
        } catch (AuthorNotFoundExceptions e) {
            System.out.println("Author with id" + e.getAuthorId() + "not found!");
        }

    }
}
