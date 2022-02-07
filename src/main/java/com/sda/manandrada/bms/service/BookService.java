package com.sda.manandrada.bms.service;

import com.sda.manandrada.bms.service.exceptions.AuthorNotFoundExceptions;

public interface BookService {

    void createBook(String isbn,String title, String description);

    void createBook(String isbn,String title, String description,Integer author_id) throws AuthorNotFoundExceptions;
}
