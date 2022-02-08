package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.model.Author;
import com.sda.manandrada.bms.model.Book;
import com.sda.manandrada.bms.repository.AuthorRepository;
import com.sda.manandrada.bms.repository.AuthorRepositoryImpl;
import com.sda.manandrada.bms.repository.BookRepository;
import com.sda.manandrada.bms.repository.BookRepositoryImpl;
import com.sda.manandrada.bms.service.exceptions.AuthorNotFoundExceptions;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;//cand declar folosec tot tipul interfata
    private AuthorRepository authorRepository;

    public BookServiceImpl() {
        bookRepository = new BookRepositoryImpl();
        authorRepository = new AuthorRepositoryImpl();

    }

    public void createBook(String isbn, String title, String description) {
        Book book = new Book();

        book.setIsbn(isbn);
        book.setTitle(title);
        book.setDescription(description);

        bookRepository.createBook(book);
    }

    @Override
    public void createBook(String isbn, String title, String description, Integer author_id) throws AuthorNotFoundExceptions {
        Author author = authorRepository.findById(author_id);
        if(author !=null) {

            Book book = new Book();

            book.setIsbn(isbn);
            book.setTitle(title);
            book.setDescription(description);
            book.setAuthor(author);

            bookRepository.createBook(book);

        }else{
            throw  new AuthorNotFoundExceptions("Author not found",author_id);
        }
    }

}
