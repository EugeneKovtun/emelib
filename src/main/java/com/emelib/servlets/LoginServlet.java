package com.emelib.servlets;

import com.emelib.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            processUser(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            processUser(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processUser(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        try {
            System.out.println("LoginServlet.processUser");
            System.out.println(req.getParameter("login") + " " + req.getParameter("password"));
            int id = UserDAO.getIdByLogin(req.getParameter("login"), req.getParameter("password"));
            System.out.println(2);
            req.getSession().setAttribute("userID", id);
            resp.sendRedirect(req.getContextPath() + "/");
        } catch (IllegalArgumentException e) {
            System.out.println("Errr");
            resp.sendRedirect(req.getContextPath() + "/signInUp");
        }

//        req.getSession().setAttribute("userID", 1);
//        resp.sendRedirect(req.getContextPath() + "/");
    }
}
