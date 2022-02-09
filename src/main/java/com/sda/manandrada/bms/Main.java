package com.sda.manandrada.bms;

import com.sda.manandrada.bms.controller.*;
import com.sda.manandrada.bms.model.Review;
import com.sda.manandrada.bms.service.AuthorService;
import com.sda.manandrada.bms.service.AuthorServiceImpl;
import com.sda.manandrada.bms.service.BookService;
import com.sda.manandrada.bms.service.BookServiceImpl;
import com.sda.manandrada.bms.utils.SessionManager;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;
//ctrl alt o optimizeaza importurile

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);//constanta

    public static void main(String[] args) {

        //un apel de SessionManager.getSessionFactory()
        SessionManager.getSessionFactory();//asa facem sa apara initializarea la inceput.

        //citirea fisierului
        //  AuthorService authorService=new AuthorServiceImpl();
        //  authorService.importAuthorsFromFile();
//
        //  BookService bookService=new BookServiceImpl();
        //  bookService.importBooksFromFile();

        BookController bookController = new BookControllerImpl();
        AuthorController authorController = new AuthorControllerImpl();
        ReviewController reviewController = new ReviewControlIerImpl();
        System.out.println("BookingManagementSystem is starting.");
        String option = null;
        do {
            printMenu();
            System.out.println("Please insert your option: ");
            option = SCANNER.nextLine();
            MenuOption menuOption = findByOption(option);

            switch (menuOption) {
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case VIEW_ALL_AUTHOR:
                    authorController.viewAllAuthors();
                    break;
                case UPDATE_AUTHOR:
                    authorController.updateAuthor();
                    break;
                case DELETE_AUTHOR:
                    authorController.deleteAuthor();
                    break;

                case CREATE_BOOK:
                    bookController.createBook();
                    break;
                case CREATE_BOOK_WITH_AUTHOR:
                    bookController.createBookWithAuthor();
                    break;

                case ADD_REVIEW:
                    reviewController.addReview();
                    break;


                case EXIT:
                    System.out.println("Bye bye");
                    break;
                default:
                    System.out.println("Option is not valid!");

            }
        } while (option == null || !option.equals("EXIT"));

        SessionManager.shutDown();
    }

    private static void printMenu() {
        System.out.println("Create Menu");
        // System.out.println("1:CREATE BOOK");
        // System.out.println("2:CREATE AUTHOR");
        // System.out.println("EXIT:EXIT");
        //MenuOption menuOption=MenuOption.CREATE_BOOK; //in loc de tot ce am pus cometariu
        //sau
        //   MenuOption.values(); //values ret un array cu toate vall menuOption
        for (MenuOption menuOption : MenuOption.values()) {
            if (!(menuOption.equals(MenuOption.UNDEFINED))) {
                System.out.println(menuOption.getOption() + " " + menuOption.getDescription());
            }
        }
    }

    public static MenuOption findByOption(String option) {
        for (MenuOption menuOption : MenuOption.values()) {
            if (menuOption.getOption().equals(option)) {
                return menuOption;
            }
        }
        return MenuOption.UNDEFINED;
    }
}