package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.model.Review;
import com.sda.manandrada.bms.service.exceptions.AuthorNotFoundExceptions;
import com.sda.manandrada.bms.service.exceptions.BookNotFoundException;

import java.util.List;

public interface BookService {

    void createBook(String isbn,String title, String description);

    void createBook(String isbn,String title, String description,Integer author_id) throws AuthorNotFoundExceptions;

    void importBooksFromFile();

    List<Review> getReviewsForBook(Integer bookId) throws BookNotFoundException;
}
