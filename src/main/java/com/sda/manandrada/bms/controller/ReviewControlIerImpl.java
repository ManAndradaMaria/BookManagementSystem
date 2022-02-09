package com.sda.manandrada.bms.controller;

import com.sda.manandrada.bms.model.Book;
import com.sda.manandrada.bms.service.BookService;
import com.sda.manandrada.bms.service.BookServiceImpl;
import com.sda.manandrada.bms.service.ReviewService;
import com.sda.manandrada.bms.service.ReviewServiceImpl;
import com.sda.manandrada.bms.service.exceptions.BookNotFoundException;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.hibernate.loader.collection.OneToManyJoinWalker;

import java.util.Scanner;

public class ReviewControlIerImpl implements ReviewController {

    private static final Scanner SCANNER = new Scanner(System.in);
    private ReviewService reviewService;
    private BookService bookService;

    public ReviewControlIerImpl() {
        this.reviewService = new ReviewServiceImpl();
        this.bookService = new BookServiceImpl();
    }

    @Override
    public void addReview() {

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

    @Override
    public void getReviewForBook() {
        System.out.println("Please insert book id: ");
        Integer bookId = Integer.parseInt(SCANNER.nextLine());
        try {

            bookService.getReviewsForBook(bookId)
                    .stream()
                    .limit(10)
                    .forEach(review -> {
                        System.out.println("Score: " + review.getScore());
                        System.out.println("Comment: " + review.getComment());
                    });

        } catch (BookNotFoundException e) {
            System.out.println("Book not found!");
        }
    }
}
