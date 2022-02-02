package com.sda.manandrada.bms;

import com.sda.manandrada.bms.model.Author;
import com.sda.manandrada.bms.model.Book;
import com.sda.manandrada.bms.model.Review;
import com.sda.manandrada.bms.utils.SessionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

    public static void main(String[] args) {

        System.out.println("BookingManagementSystem is starting.");
        // SessionManager //nu am voie sa-l instantiez
        SessionFactory sessionFactory = SessionManager.getSessionFactory();

        Session session = sessionFactory.openSession();//am deschis sesiunea

        Author author = new Author();
        author.setFirstName("Creanga");
        author.setLastName("Ion");
        session.save(author);


        Book book = new Book();
        book.setAuthor(author);
        book.setTitle("Amintiri din copilarie");
        book.setIsbn("1234-jhf");
        book.setDescription("Povesti pentru copii");
        session.save(book);

        Review review=new Review();
        review.setBook(book);
        review.setComment("aaaaaa");
        review.setScore(10);
        session.save(review);


        session.close();


        SessionManager.shutDown();

    }
}
