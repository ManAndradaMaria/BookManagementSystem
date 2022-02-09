package com.sda.manandrada.bms.repository;

import com.sda.manandrada.bms.model.Review;

public class ReviewRepositoryImpl extends BaseRepositoryImpl<Review, Integer> implements ReviewRepository {

    public ReviewRepositoryImpl() {
        super(Review.class);
    }
    
}
