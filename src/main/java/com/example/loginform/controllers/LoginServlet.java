package com.example.loginform.controllers;

import com.example.loginform.database.UserData;
import com.example.loginform.dbRunTime.Users;
import com.example.loginform.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        UserData userDao = new UserData();
        Users users = userDao.getDatabaseContent();

        if(request.getParameter("login")!= null) {
            String password = request.getParameter("password");

            if (users.findUser(new User(username,password))) {
                request.getSession().setAttribute("username", username);
                response.setContentType("text/html");
                request.setAttribute("username", username);
                RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        }
        if(request.getParameter("signup")!= null) {
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            rd.include(request, response);
        }
        if(request.getParameter("forgotPassword")!= null) {
            if(!username.isEmpty() && users.findUserByUsername(username)!=null) {
                request.getSession().setAttribute("username", username);
                response.setContentType("text/html");
                request.setAttribute("username", username);
                RequestDispatcher rd = request.getRequestDispatcher("/forgotpassword.jsp");
                rd.forward(request, response);
            }else {
                response.setContentType("text/html");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}
