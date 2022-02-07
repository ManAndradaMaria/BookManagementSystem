package com.sda.manandrada.bms.repository;

import com.sda.manandrada.bms.model.Author;
import com.sda.manandrada.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AuthorRepositoryImpl implements AuthorRepository {

    @Override
    public void createAuthor(Author author) {
        //session e ob cu care lucram mereu,conex la baza de date
        Session session = SessionManager.getSessionFactory().openSession();

        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();//incepe tranzactia pe baza de date

            session.save(author);//aici e querry-ul,salvez obiectul

            transaction.commit();
        } catch (Exception ex) {

            ex.getStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        session.close();
    }

    @Override
    public Author findById(Integer id) {
        //id e cheie primara
        Session session = SessionManager.getSessionFactory().openSession();
        Author author = session.find(Author.class, id);//cautam un id pt autorul respectiv

        session.close();
        return author;//returmeaza de ceva de tip autor

    }

    @Override
    public List<Author> findAll() {
        Session session = SessionManager.getSessionFactory().openSession();
        List<Author> authors = session.createQuery("from Author", Author.class).list();

        session.close();
        return authors;
    }
}
