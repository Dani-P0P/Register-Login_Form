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

@WebServlet(name = "ForgotPasswordServlet", urlPatterns = "/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("exit")!= null) {
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
            return;
        }

        if(request.getParameter("save")!= null) {
            String username = (String)request.getSession().getAttribute("username");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmpassword");
            UserData userDao = new UserData();
            Users users = userDao.getDatabaseContent();

            if (users.findUserByUsername(username)!=null && password.equals(confirmPassword) && !password.isEmpty()) {
                userDao.updatePassword(new User(username,password));
                response.setContentType("text/html");
                RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/forgotpassword.jsp");
                rd.include(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
