package com.project.filters;

import com.project.db.DBManager;
import com.project.db.Users;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "UserFilter",urlPatterns = "/*")
public class UserFilter implements Filter {
    private DBManager dbManager;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        boolean userOnline = false;

        Users user = (Users) ((HttpServletRequest)req).getSession().getAttribute("SESSION_USER");
        //System.out.println(user);
        if (user!=null){
            Users tempUser = dbManager.checkUser(user.getEmail(),user.getPassword());
            if (tempUser!=null){
                userOnline = true;

            }else {
                req.getRequestDispatcher("home.jsp?error=1").forward(req,resp);
            }
        }
        req.setAttribute("userOnline", userOnline);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        dbManager = new DBManager();
    }

}
