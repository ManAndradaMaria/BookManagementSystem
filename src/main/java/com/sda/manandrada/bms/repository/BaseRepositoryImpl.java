package com.sda.manandrada.bms.repository;

import com.sda.manandrada.bms.model.Author;
import com.sda.manandrada.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaseRepositoryImpl<T, ID> implements  BaseRepository<T,ID>{//T e author aici, id e tipul id-ului

    private final Class<T> clazz;

    public BaseRepositoryImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void createEntity(T entity) {
        //session e ob cu care lucram mereu,conex la baza de date
        Session session = SessionManager.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();//incepe tranzactia pe baza de date

            session.save(entity);//aici e querry-ul,salvez obiectul,tr la baza de date

            transaction.commit();
        } catch (Exception ex) {

            ex.getStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }
    public T findById(ID id) { //T este entitatea, poate fi book review ...

        Session session = SessionManager.getSessionFactory().openSession();
        T entity=session.find(clazz,id);//Author.class l-am inlocuit cu clazz

        session.close();
        return entity;
    }
}
