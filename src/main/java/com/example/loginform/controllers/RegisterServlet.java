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

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("register")!= null) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repeatPassword = request.getParameter("repeatPassword");

            request.getSession().setAttribute("username", username);
            UserData userDao = new UserData();
            Users users = userDao.getDatabaseContent();

            if(!username.isEmpty() && users.findUserByUsername(username)==null && !password.isEmpty() && password.equals(repeatPassword)) {
                userDao.setNewUser(new User(username,password));
                RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
                rd.include(request, response);
            }
        }
        if(request.getParameter("exit")!= null) {
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
