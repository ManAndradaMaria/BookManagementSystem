package com.sda.manandrada.bms.controller;

import com.sda.manandrada.bms.service.ReviewService;
import com.sda.manandrada.bms.service.ReviewServiceImpl;
import com.sda.manandrada.bms.service.exceptions.BookNotFoundException;
import org.hibernate.loader.collection.OneToManyJoinWalker;

import java.util.Scanner;

public class ReviewControlIerImpl implements ReviewController {

    private static final Scanner SCANNER = new Scanner(System.in);
    private ReviewService reviewService;

    public ReviewControlIerImpl() {
        this.reviewService = new ReviewServiceImpl();
    }

    @Override
    public void addReview() {

        System.out.println("Please insert Review:");
        System.out.println("Please insert the Book Id");
        Integer bookId = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Please insert the score:");
        Integer score = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Please insert the comment:");
        String comment = SCANNER.nextLine();
        try {
            reviewService.createReview(score, comment, bookId);
        } catch (BookNotFoundException e) {
            System.out.println("Book not found!");
        }
    }
}
