package com.sda.manandrada.bms.controller;

import com.sda.manandrada.bms.service.AuthorService;
import com.sda.manandrada.bms.service.AuthorServiceImpl;

import java.util.Scanner;

public class AuthorControllerImpl implements AuthorController {

    private static final Scanner SCANNER = new Scanner(System.in);
    private AuthorService authorService;

    public AuthorControllerImpl() {
        authorService = new AuthorServiceImpl();
    }

    @Override
    public void createAuthor() {
        System.out.println("Create Author");
        System.out.println("Please Insert firstName: ");
        String firstName = SCANNER.nextLine();
        System.out.println("Please Insert lastName: ");
        String lastName = SCANNER.nextLine();

        authorService.createAuthor(firstName, lastName);
    }
}
