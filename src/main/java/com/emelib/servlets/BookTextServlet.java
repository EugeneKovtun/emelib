package com.emelib.servlets;

import com.emelib.dao.BookDAO;
import com.emelib.entities.Book;
import com.emelib.utils.BookUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookTextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("userID") == null) {
            try {

                int id = Integer.parseInt(req.getParameter("id"));
                Book book = BookDAO.getById(id);
                req.setAttribute("name", book.getName());
                req.setAttribute("text", BookUtils.getBookText(book, false));
                req.getRequestDispatcher("notSignText.jsp").forward(req, resp);
            } catch (Exception e) {
                req.getRequestDispatcher("PageNotFound.jsp").forward(req, resp);
            }
        } else {
            try {

                int id = Integer.parseInt(req.getParameter("id"));
                int userID = (int) req.getSession().getAttribute("userID");
                Book book = BookDAO.getById(id);
                req.setAttribute("name", book.getName());
                req.setAttribute("text", BookUtils.getBookText(book, BookUtils.ifUserHaveBook(id, userID)));
                req.getRequestDispatcher("SignText.jsp").forward(req, resp);
            } catch (Exception e){
                req.getRequestDispatcher("PageNotFound.jsp").forward(req, resp);
            }
        }
    }
}
