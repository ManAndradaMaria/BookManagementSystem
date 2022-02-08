package com.sda.manandrada.bms.repository;

import com.sda.manandrada.bms.model.Book;

//interfata
public interface BookRepository extends BaseRepository<Book, Integer> {

    void createBook(Book book);

  //  Book findById(Integer id);


}
