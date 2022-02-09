package com.sda.manandrada.bms.repository;

import com.sda.manandrada.bms.model.Book;
import com.sda.manandrada.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

//clasa pt implementare
public class BookRepositoryImpl extends BaseRepositoryImpl<Book, Integer> implements BookRepository {

    public BookRepositoryImpl() {
        super(Book.class);
    }

    public void createBook(Book book) {

        //  //session e ob cu care lucram mereu,conex la baza de date
        //  Session session = SessionManager.getSessionFactory().openSession();

        //  Transaction transaction = null;

        //  try {
        //      transaction = session.beginTransaction();//incepe tranzactia pe baza de date

        //      session.save(book);//aici e querry-ul

        //      transaction.commit();
        //  } catch (Exception ex) {

        //      ex.getStackTrace();
        //      if (transaction != null) {
        //          transaction.rollback();
        //      }
        //  }
        //  session.close();

        createEntity(book);
    }

    @Override
    public Book findByIdAndLoadReviews(int id) {

        Session session = SessionManager.getSessionFactory().openSession();

        Book book = session.find(Book.class, id);
        System.out.println(book.getReviews().size());//incarcarea datelor in interiorul sesiunii

        session.close();
        return book;
    }
}


