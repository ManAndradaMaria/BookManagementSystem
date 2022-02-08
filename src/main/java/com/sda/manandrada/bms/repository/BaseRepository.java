package com.sda.manandrada.bms.repository;

import com.sda.manandrada.bms.model.Book;

public interface BaseRepository <T,ID>  {
    void createEntity(T entity);

    T findById(ID id);

    void update(T entity);

    void delete(T entity);

}
