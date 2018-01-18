package com.emelib.servlets;

import com.emelib.dao.BookDAO;
import com.emelib.entities.Book;
import com.emelib.utils.BookUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Book book = BookDAO.getById(id);
            req.setAttribute("name", book.getName());
            req.setAttribute("author", book.getAuthor());
            req.setAttribute("price", book.getPrice());
            req.setAttribute("description", book.getDescription());
            req.getRequestDispatcher("SignInfoBook.jsp").forward(req, resp);
        } catch (Exception e) {
            req.getRequestDispatcher("404.html").forward(req, resp);
            e.printStackTrace();
        }

    }
}
