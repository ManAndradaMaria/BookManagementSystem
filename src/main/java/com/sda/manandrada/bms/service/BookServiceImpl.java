package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.model.Book;
import com.sda.manandrada.bms.repository.BookRepository;
import com.sda.manandrada.bms.repository.BookRepositoryImpl;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;//cand declar folosec tot timpul interfata

    public BookServiceImpl() {
        bookRepository = new BookRepositoryImpl();
    }

    public void createBook(String isbn, String title, String description) {
        Book book = new Book();

        book.setIsbn(isbn);
        book.setTitle(title);
        book.setDescription(description);
        bookRepository.createBook(book);
    }

}
