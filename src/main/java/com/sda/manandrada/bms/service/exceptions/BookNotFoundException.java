package com.sda.manandrada.bms.service.exceptions;

public class BookNotFoundException extends Exception {

    private Integer bookId;

    public BookNotFoundException(String message, Integer bookId) {
        super(message);
        this.bookId = bookId;
    }

    public Integer getBookId() {
        return bookId;
    }
}
