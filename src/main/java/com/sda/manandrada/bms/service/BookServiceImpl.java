package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.model.Author;
import com.sda.manandrada.bms.model.Book;
import com.sda.manandrada.bms.model.Review;
import com.sda.manandrada.bms.repository.AuthorRepository;
import com.sda.manandrada.bms.repository.AuthorRepositoryImpl;
import com.sda.manandrada.bms.repository.BookRepository;
import com.sda.manandrada.bms.repository.BookRepositoryImpl;
import com.sda.manandrada.bms.service.exceptions.AuthorNotFoundExceptions;
import com.sda.manandrada.bms.service.exceptions.BookNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        if (author != null) {

            Book book = new Book();

            book.setIsbn(isbn);
            book.setTitle(title);
            book.setDescription(description);
            book.setAuthor(author);

            bookRepository.createBook(book);

        } else {
            throw new AuthorNotFoundExceptions("Author not found", author_id);
        }
    }

    @Override
    public void importBooksFromFile() {

        Path bookFileAbsolutePath = Paths.get("C:\\Users\\Dell\\Documents\\BookManagementSystem\\data\\Books.txt.crdownload");
        try {
            Files.lines(bookFileAbsolutePath)
                    .filter(line -> line != null)
                    .filter(line -> !line.isEmpty())
                    .skip(1)
                    .forEach(line -> {
                        try {
                            String[] elements = line.split("\\|");//spargem linia in bucati
                            createBook(elements[0], elements[1], elements[2], Integer.parseInt(elements[3]));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Review> getReviewsForBook(Integer bookId) throws BookNotFoundException {
        Book book = bookRepository.findByIdAndLoadReviews(bookId); //metoda dedicata care incarca si review , amm facut asta pt rezolvarea problemei lazy
        if (book != null) {
            return book.getReviews();
        } else {
            throw new BookNotFoundException("not found book", bookId);
        }

    }

}
