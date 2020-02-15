package com.project.servlets;

import com.project.db.Blogs;
import com.project.db.DBManager;
import com.project.db.Users;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "HomeServlet", value = "/load")
public class HomeServlet extends javax.servlet.http.HttpServlet {

    DBManager dbManager = new DBManager();

    public void init() {
        dbManager = new DBManager();
        dbManager.connect();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        Users sessionUser = (Users) request.getSession().getAttribute("SESSION_USER");

        boolean userOnline = sessionUser != null;

        String uri = "";
        String act = request.getParameter("act");

        if (act != null) {
            if (act.equals("add_user")) {

                uri = "load?page=adduser&error=1";

                String email = request.getParameter("email");
                String password = request.getParameter("password");
                String rePassword = request.getParameter("re_password");
                String fullName = request.getParameter("full_name");

                if (email != null && !email.equals("") && password != null && !password.equals("") && rePassword != null && fullName != null && !fullName.equals("")) {

                    if (password.equals(rePassword)) {

                        Users user = dbManager.getUser(email);
                        if (user == null) {

                            dbManager.addUser(new Users(null, email, password, fullName));
                            uri = "load?page=adduser&success=1";
                        }
                    }

                }
            } else if (act.equals("addblog") && userOnline) {

                String title = request.getParameter("title");
                String shortContent = request.getParameter("short_content");
                String content = request.getParameter("content");

                dbManager.addBlog(new Blogs(sessionUser,title, shortContent, content));
                uri = "load?page=addblog&success=1";
                }
            }else if(act.equals("delete") && userOnline){

            Long userId = Long.parseLong(request.getParameter("id"));
            System.out.println(userId);
            dbManager.deleteUser(sessionUser.getId());

            uri = "?";

            }
            response.sendRedirect("/" + uri);
        }

        protected void doGet (javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse
        response) throws javax.servlet.ServletException, IOException {
            String jspPage = "index";
            String page = request.getParameter("page");
            boolean userOnline = (boolean) request.getAttribute("userOnline");
            if (page!=null&&!page.equals("")){
                if (userOnline){
                    jspPage = "profile";
                    if (page.equals("home")){
                        jspPage = "index";
                    }
                    if (page.equals("profile")){
                        Users user = (Users) request.getSession().getAttribute("SESSION_USER");
                        request.setAttribute("user", user);
                        jspPage = "profile";
                    }
                    if (page.equals("addblog")){
                        jspPage = "addblog";
                    }
                    if (page.equals("readblog")){
                        jspPage = "404";
                        String id = request.getParameter("id");
                        System.out.println(id);
                        Long longId = null;
                        Blogs blog = null;

                        try {

                            longId = Long.parseLong(id);

                        }catch (Exception e){

                        }
                        System.out.println("Long"+longId);
                        if(longId!=null){
                            blog = dbManager.getBlog(longId);
                            if(blog!=null){
                                request.setAttribute("blog", blog);
                                jspPage = "readblog";
                            }
                        }
                        //jspPage = "readblog";
                    }
                }else {
                    if (page.equals("home")){
                        jspPage = "index";
                    }
                    if (page.equals("login")){
                        jspPage = "login";
                    }
                    if (page.equals("adduser")){
                        jspPage = "adduser";
                    }
                }

            }

            ArrayList<Blogs> blogs = dbManager.getAllBlogs();
            request.setAttribute("blogs", blogs);





            request.getRequestDispatcher("views/"+jspPage+".jsp").forward(request,response);

        }
}
