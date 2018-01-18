package com.emelib.utils;

import com.emelib.dao.UserDAO;
import com.emelib.entities.Book;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BookUtils {
    public static String getBookLink(Book book) {
        return "<a class=\"book\" href=\"/book?id=" + book.getId() + "\">" + book.getName() + "</a>";
    }

    public static StringBuffer getBookText(Book book, boolean isAvailable) throws IOException {
        StringBuffer buffer = new StringBuffer();
        Files.lines(Paths.get(book.getFile()), StandardCharsets.UTF_8).forEach(buffer::append);
        if (isAvailable) {
            return buffer;
        } else {
            buffer.setLength((int) (buffer.length() * 0.2));
            buffer.append("\nTo Read next buy this book");
            return buffer;
        }
    }

    public static boolean ifUserHaveBook(int bookId, int userID) {
        for (Book book : UserDAO.getById(userID).getBooks()) {
            if (book.getId() == bookId) {
                return true;
            }
        }
        return false;
    }

}
