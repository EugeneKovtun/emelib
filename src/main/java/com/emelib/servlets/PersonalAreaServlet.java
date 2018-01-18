package com.emelib.servlets;

import com.emelib.dao.UserDAO;
import com.emelib.entities.Account;
import com.emelib.entities.Book;
import com.emelib.utils.BookUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PersonalAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processUser(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processUser(req, resp);
    }

    private void processUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("userID") == null) {
            req.getRequestDispatcher("PageNotFound.jsp").forward(req, resp);
        } else {
            Account account = UserDAO.getById((Integer) req.getSession().getAttribute("userID"));
            //System.out.println(account);
            //List<Book> books = account.getBooks();
            StringBuffer buffer = new StringBuffer();
            try {
                for (Book book : account.getBooks()) {
                    buffer.append("<li><div>" + BookUtils.getBookLink(book) + "</div></li>");
                }
            } catch (NullPointerException n) {
                n.printStackTrace();
            }
            req.setAttribute("books", buffer);
            req.setAttribute("login", account.getLogin());
            req.getRequestDispatcher("personalArea.jsp").forward(req, resp);

        }
    }
}
