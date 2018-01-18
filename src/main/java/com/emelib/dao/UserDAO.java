package com.emelib.dao;

import com.emelib.entities.Account;
import com.emelib.entities.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Collections;
import java.util.List;

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

    public static Account getById(int id) {
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
        Account account = session.get(Account.class, id);
        transaction.commit();
        return account;
    }

    public static int getIdByLogin(String login, String password) throws Exception {
        List<Account> accounts = getAll();
        for (Account account:accounts) {
            if (account.getLogin().equals(login)&&account.getPassword().equals(password)){
                return account.getId();
            }
        }
        throw new IllegalArgumentException();
    }

    private static List<Account> getAll() {
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
        List<Account> accounts = session.createCriteria(Account.class).list();
        transaction.commit();
        return accounts;
    }
    public static void addBookToUser(Book book, Account account){
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
            account.getBooks().add(book);
            book.getAccounts().add(account);
            session.merge(account);

        transaction.commit();
    }
}
