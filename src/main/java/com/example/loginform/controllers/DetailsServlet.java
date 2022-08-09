package com.example.loginform.controllers;

import com.example.loginform.database.UserData;
import com.example.loginform.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetailsServlet", urlPatterns = "/details")
public class DetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("exit") != null) {
            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
            return;
        }

        if (request.getParameter("save") != null) {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String date = request.getParameter("birthdate");
            UserData userDao = new UserData();

            userDao.updateUser(new User((String) request.getSession().getAttribute("username"), name, address, date));

            response.setContentType("text/html");
            RequestDispatcher rd = request.getRequestDispatcher("/details.jsp");
            rd.forward(request, response);

        }

    }
}
