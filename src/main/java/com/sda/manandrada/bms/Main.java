package com.sda.manandrada.bms;

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
        System.out.println("BookingManagementSystem is starting.");
        String option = null;
        do {
            printMenu();
            System.out.println("Please insert your option: ");
            option = SCANNER.nextLine();
            switch (option) {
                case "1":
                    bookController.createBook();
                    break;
                case "EXIT":
                    System.out.println("Finish");
                    break;
                default:
                    System.out.println("Option is not valid!");

            }
        } while (option == null || !option.equals("EXIT"));

        SessionManager.shutDown();

    }

    private static void printMenu() {
        System.out.println("1:CREATE BOOK");
        System.out.println("EXIT:EXIT");
    }
}
