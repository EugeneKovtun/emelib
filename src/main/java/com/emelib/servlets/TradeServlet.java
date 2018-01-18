package com.emelib.servlets;

import com.emelib.dao.BookDAO;
import com.emelib.dao.UserDAO;
import com.emelib.utils.BookUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TradeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            System.out.println(id);
            int userID = (int) req.getSession().getAttribute("userID");
            System.out.println(userID);
            UserDAO.addBookToUser(BookDAO.getById(id), UserDAO.getById(userID));
            req.getRequestDispatcher("SuccessTrade.jsp").forward(req, resp);
        } catch (Exception e){
            req.getRequestDispatcher("PageNotFound.jsp").forward(req, resp);

        }
    }
}
