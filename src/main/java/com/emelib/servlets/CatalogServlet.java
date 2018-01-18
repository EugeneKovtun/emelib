package com.emelib.servlets;

import com.emelib.dao.BookDAO;
import com.emelib.entities.Book;
import com.emelib.utils.BookUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processUser(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processUser(req,resp);
    }
    private void processUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = BookDAO.getAll();
        StringBuffer buffer = new StringBuffer();
        for (Book book:
             books) {
            buffer.append("<li><div>"+ BookUtils.getBookLink(book)+"</div></li>");
        }
        req.setAttribute("books",buffer);
        if (req.getSession().getAttribute("userID") == null) {
            req.getRequestDispatcher("notSignCatalog.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("SignCatalog.jsp").forward(req, resp);
        }
    }
}
