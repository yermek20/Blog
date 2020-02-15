package com.project.servlets;

import com.project.db.DBManager;
import com.project.db.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.UnknownServiceException;

@WebServlet(name = "AuthServlet",value = "/auth")
public class AuthServlet extends HttpServlet {
    private DBManager dbManager;
    public void init() throws ServletException {
        dbManager = new DBManager();
        dbManager.connect();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Users user = dbManager.getUser(email,password);
        if (user!=null){
            request.getSession().setAttribute("SESSION_USER",user);

        }
        response.sendRedirect("load");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
