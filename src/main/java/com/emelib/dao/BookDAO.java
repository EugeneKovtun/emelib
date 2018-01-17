package com.emelib.dao;

import com.emelib.entities.Account;
import com.emelib.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class BookDAO {
    public static void addBook(Book book) {
        Configuration configuration = new Configuration()
                .configure().addAnnotatedClass(Book.class)
                .addAnnotatedClass(Account.class);
        ServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
    }
    public static Book getById(int id){
        Configuration configuration = new Configuration()
                .configure().addAnnotatedClass(Book.class)
                .addAnnotatedClass(Account.class);
        ServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Book book= session.get(Book.class, id);
        transaction.commit();
        return book;
    }
}
