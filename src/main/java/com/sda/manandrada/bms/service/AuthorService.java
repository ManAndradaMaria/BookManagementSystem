package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.model.Author;

import java.util.List;

public interface AuthorService {

    void createAuthor(String firstName, String lastName);

    List<Author> findAll();
}
