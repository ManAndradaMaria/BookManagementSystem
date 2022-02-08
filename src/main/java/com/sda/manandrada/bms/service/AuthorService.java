package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.model.Author;
import com.sda.manandrada.bms.service.exceptions.AuthorNotFoundExceptions;

import java.util.List;

public interface AuthorService {

    void createAuthor(String firstName, String lastName);

    List<Author> findAll();

    void importAuthorsFromFile();

    void update(Integer id,String firstName, String lastName) throws AuthorNotFoundExceptions;

    void delete(Integer id) throws AuthorNotFoundExceptions;

}
