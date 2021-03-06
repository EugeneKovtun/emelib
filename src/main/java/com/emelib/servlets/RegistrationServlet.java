package com.emelib.servlets;

import com.emelib.dao.UserDAO;
import com.emelib.entities.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            if (login.length()<2||password.length()<2){
                throw new Exception();
            }
            Account account = new Account();
            account.setLogin(login);
            account.setPassword(password);
            UserDAO.addUser(account);
            req.getRequestDispatcher("Success.jsp").forward(req,resp);
            //req.getRequestDispatcher("signInUp/success.html").forward(req, resp);

        }
        catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/signInUp");
//            req.getRequestDispatcher("/signInUp").forward(req, resp);
        }
    }
}
