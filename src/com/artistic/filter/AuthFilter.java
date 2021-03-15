package com.artistic.filter;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

@WebFilter("/authfilter")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        String password = servletRequest.getParameter("");
        if(password.equals("Filter")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            out.println("Email or Password is wrong!");
            RequestDispatcher rd = servletRequest.getRequestDispatcher("index.jsp");
            rd.include(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
