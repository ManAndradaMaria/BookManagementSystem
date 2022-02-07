package com.sda.manandrada.bms.repository;

import com.sda.manandrada.bms.model.Author;

import java.util.List;

public interface AuthorRepository {

    void createAuthor(Author author);

    Author findById(Integer id);

    List<Author> findAll();

}
