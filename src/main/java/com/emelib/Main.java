package com.emelib;

import com.emelib.dao.BookDAO;
import com.emelib.dao.UserDAO;
import com.emelib.entities.Account;
import com.emelib.entities.Book;
import com.emelib.utils.BookUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Account account = new Account();
        account.setLogin("login");
        account.setPassword("password");
        Book book = new Book();
        book.setFile("/home/eugene/EmeLib/src/TheHeartOfADog.txt");
        book.setDescription("\n" +
                "Невероятный эксперимент выдающегося хирурга," +
                " который заканчивается превращением собаки в человека, а " +
                "также последствия, к которым это привело. Используя гротеск," +
                " автор вводит в обычную городскую действительность элементы фантастики");
        book.setAuthor("Михаил Булгаков");
        book.setName("Собачье сердце");
        book.setPrice(50);
        System.out.println(UserDAO.getById(2));
        //book.getAccounts().add(account);
        //account.getBooks().add(book);
        //UserDAO.addUser(account);
        //BookDAO.addBook(book);
       // Book book1 = BookDAO.getById(1);
//        UserDAO.getById(2).getBooks();
//        for (Book book2 :UserDAO.getById(2).getBooks()) {
//            if (book2.getId()==1){
//                System.out.println(true);
//            }
//        }
        System.out.println(BookUtils.ifUserHaveBook(2,2));
//        boolean idExists = UserDAO.getById(2).getBooks().stream()
//                .anyMatch(t -> t.getId().equals(idToCheck));
//        UserDAO.addBookToUser(BookDAO.getById(1),UserDAO.getById(2));
//
//        Configuration configuration = new Configuration()
//                .configure().addAnnotatedClass(Book.class)
//                .addAnnotatedClass(Account.class);
//        ServiceRegistry registry =
//                new StandardServiceRegistryBuilder()
//                        .applySettings(configuration.getProperties())
//                        .build();
//        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(account);
//        session.save(book);
//
//        // Book book1 = session.get(Book.class, 1);
//        transaction.commit();
    }
}
