package com.sda.manandrada.bms.utils;

import com.sda.manandrada.bms.model.Author;
import com.sda.manandrada.bms.model.Book;
import com.sda.manandrada.bms.model.Review;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager extends AbstractSessionManager {

    private static final SessionManager INSTANCE = new SessionManager();//pattern Singleton

    private SessionManager() {
    }

    public static SessionFactory getSessionFactory() {

        return INSTANCE.getSessionFactory("BMS");
    }

    //metoda de shutDown la hibernate
    public static void shutDown() {
        INSTANCE.shutdownSessionManager();

    }

    @Override
    protected void setAnnotatedClasses(Configuration configuration) {
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Review.class);
    }
}
