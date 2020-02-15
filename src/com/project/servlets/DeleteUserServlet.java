package com.project.servlets;

import com.project.db.DBManager;
import com.project.db.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteUserServlet",value = "/del")
public class DeleteUserServlet extends HttpServlet {
    private DBManager dbManager;
    public void init() throws ServletException {
        dbManager = new DBManager();
        dbManager.connect();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Users sessionUser = (Users) request.getSession().getAttribute("SESSION_USER");
        Long userId = Long.parseLong(request.getParameter("id"));
        System.out.println(userId);
        dbManager.deleteUser(sessionUser.getId());




        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/").forward(request,response);
    }
}
