package com.emelib.dao;

import com.emelib.entities.Account;
import com.emelib.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class UserDAO {
    public static void addUser(Account account) {
        Configuration configuration = new Configuration()
                .configure().addAnnotatedClass(Account.class)
                .addAnnotatedClass(Book.class);
        ServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
    }

}
