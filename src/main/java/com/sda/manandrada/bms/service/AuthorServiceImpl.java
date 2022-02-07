package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.model.Author;
import com.sda.manandrada.bms.repository.AuthorRepository;
import com.sda.manandrada.bms.repository.AuthorRepositoryImpl;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    public AuthorServiceImpl() {//sa nu aiba acces nimeni
        authorRepository = new AuthorRepositoryImpl();
    }

    @Override
    public void createAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.createAuthor(author);
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }
}
