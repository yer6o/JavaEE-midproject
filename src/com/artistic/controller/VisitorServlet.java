package com.artistic.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.artistic.dao.VisitorDAO;
import com.artistic.model.Visitor;


@WebServlet("/visitor-register")
public class VisitorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VisitorDAO visitorDAO;

    public void init() {
        visitorDAO = new VisitorDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String Email = request.getParameter("Email");
        String password = request.getParameter("password");

        Visitor visitor = new Visitor();
        visitor.setFname(fName);
        visitor.setLname(lName);
        visitor.setEmail(Email);
        visitor.setPassword(password);
        try {
            visitorDAO.registerVisitor(visitor);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<h2>Welcome " + fName + " " + lName + "!");
        out.println("</html>");
    }
}