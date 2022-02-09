package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.service.exceptions.BookNotFoundException;

public interface ReviewService {

    void createReview(Integer score, String comment, Integer bookId) throws BookNotFoundException;
    //id vine automat, cheie primara

}
