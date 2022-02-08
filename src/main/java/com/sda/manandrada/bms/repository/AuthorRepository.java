package com.sda.manandrada.bms.repository;

import com.sda.manandrada.bms.model.Author;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.List;

public interface AuthorRepository extends BaseRepository <Author, Integer>{

    void createAuthor(Author author);

  //  Author findById(Integer id); datorita baseRepository nu mai am nevoie de asta

    List<Author> findAll();

}
