package com.sda.manandrada.bms;

import com.sda.manandrada.bms.controller.AuthorController;
import com.sda.manandrada.bms.controller.AuthorControllerImpl;
import com.sda.manandrada.bms.controller.BookController;
import com.sda.manandrada.bms.controller.BookControllerImpl;
import com.sda.manandrada.bms.utils.SessionManager;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;
//ctrl alt o optimizeaza importurile

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);//constanta

    public static void main(String[] args) {

        BookController bookController = new BookControllerImpl();
        AuthorController authorController = new AuthorControllerImpl();
        System.out.println("BookingManagementSystem is starting.");
        String option = null;
        do {
            printMenu();
            System.out.println("Please insert your option: ");
            option = SCANNER.nextLine();
            MenuOption menuOption = findByOption(option);

            switch (menuOption) {
                case CREATE_BOOK:
                    bookController.createBook();
                    break;
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case CREATE_BOOK_WITH_AUTHOR:
                    bookController.createBookWithAuthor();
                    break;
                case EXIT:
                    System.out.println("Finish");
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