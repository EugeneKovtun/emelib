package com.emelib.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter printWriter = response.getWriter();
//        printWriter.print("1111");
       // request.getRequestDispatcher("notSignMain.jsp").forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("MainServlet.doGet");
        System.out.println(request.getSession().getAttribute("userID"));
        if (request.getSession().getAttribute("userID") ==null) {
            System.out.println("if");
            //response.sendRedirect(request.getContextPath() + "/notSignMain.jsp");

           request.getRequestDispatcher("notSignMain.jsp").forward(request, response);

        } else {
            System.out.println("else");
            //response.sendRedirect(request.getContextPath() + "/SignMain.jsp");
            request.getRequestDispatcher("SignMain.jsp").forward(request, response);
        }
    }

}
