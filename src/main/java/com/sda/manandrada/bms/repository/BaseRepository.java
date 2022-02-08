package com.sda.manandrada.bms.repository;

public interface BaseRepository <T,ID>  {
    void createEntity(T entity);

    T findById(ID id);

}
