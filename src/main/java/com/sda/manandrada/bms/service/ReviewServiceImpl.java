package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.model.Book;
import com.sda.manandrada.bms.model.Review;
import com.sda.manandrada.bms.repository.BookRepository;
import com.sda.manandrada.bms.repository.BookRepositoryImpl;
import com.sda.manandrada.bms.repository.ReviewRepository;
import com.sda.manandrada.bms.repository.ReviewRepositoryImpl;
import com.sda.manandrada.bms.service.exceptions.BookNotFoundException;

public class ReviewServiceImpl implements ReviewService {

    private BookRepository bookRepository;
    private ReviewRepository reviewRepository;

    public ReviewServiceImpl() {
        bookRepository = new BookRepositoryImpl();
        reviewRepository = new ReviewRepositoryImpl();
    }
    //NU GET SI SET SUNT COMP NOASTRE INTERNE NU DAM ACCES LA ELE!!!!!!!!!!!!!!!

    @Override//daca pusca asta inseamna ca nu e ok signatura metodei sa ma uit!!!!
    public void createReview(Integer score, String comment, Integer bookId) throws BookNotFoundException {

        Book book = bookRepository.findById(bookId);
        if (book != null) {
            Review review = new Review();
            review.setScore(score);
            review.setComment(comment);
            review.setBook(book);

            reviewRepository.createEntity(review);
        } else {
            throw new BookNotFoundException("Book not found", bookId);
        }

    }
}
