package com.sda.manandrada.bms.repository;

import com.sda.manandrada.bms.model.Author;
import com.sda.manandrada.bms.utils.SessionManager;
import org.hibernate.Session;

import java.util.List;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author,Integer> implements AuthorRepository {

    public AuthorRepositoryImpl() {
        super(Author.class);
    }

    @Override
    public void createAuthor(Author author) {
       // //session e ob cu care lucram mereu,conex la baza de date
       // Session session = SessionManager.getSessionFactory().openSession();
//
       // Transaction transaction = null;
//
       // try {
       //     transaction = session.beginTransaction();//incepe tranzactia pe baza de date
//
       //     session.save(author);//aici e querry-ul,salvez obiectul
//
       //     transaction.commit();
       // } catch (Exception ex) {
//
       //     ex.getStackTrace();
       //     if (transaction != null) {
       //         transaction.rollback();
       //     }
       // }
       // session.close();

        createEntity(author);
    }



    @Override
    public List<Author> findAll() {
        Session session = SessionManager.getSessionFactory().openSession();
        List<Author> authors = session.createQuery("from Author", Author.class).list();

        session.close();
        return authors;
    }
}
