package com.project.servlets;

import com.project.db.Blogs;
import com.project.db.DBManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "PageServlet",value = "/page")
public class PageServlet extends HttpServlet {
    DBManager dbManager = new DBManager();

    public void init() {
        dbManager = new DBManager();
        dbManager.connect();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       // request.getRequestDispatcher("views/"+jspPage+".jsp").forward(request,response);
    }
}
