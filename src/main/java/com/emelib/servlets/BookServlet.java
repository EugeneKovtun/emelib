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
        String page;
        if (req.getSession().getAttribute("userID") == null) {
            page = "notSignInfoBook.jsp";
        } else {
            page = "SignInfoBook.jsp";
            int bookID = Integer.parseInt(req.getParameter("id"));
            int userID = (Integer) req.getSession().getAttribute("userID");
            if (!BookUtils.ifUserHaveBook(bookID, userID)) {
                req.setAttribute("byu", "<button class=\"buy\"><a class=\"forBuy\" href=\"/trade?id=" + bookID + "\">Купить книгу</a></button>");
            }
        }
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Book book = BookDAO.getById(id);
            req.setAttribute("read","  <button class = \"but\"><a class=\"forBuy\" href=\"bookText?id="+id+"\">Читать Книгу</a> </button>\n");
            req.setAttribute("name", book.getName());
            req.setAttribute("author", book.getAuthor());
            req.setAttribute("price", book.getPrice());
            req.setAttribute("description", book.getDescription());
            req.getRequestDispatcher(page).forward(req, resp);
        } catch (Exception e) {
            req.getRequestDispatcher("PageNotFound.jsp").forward(req, resp);
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
