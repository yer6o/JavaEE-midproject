package com.artistic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.artistic.dao.ArtistDAO;
import com.artistic.model.Artist;


@WebServlet("/artist-register")
public class ArtistServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArtistDAO artistDAO;

    public void init() {
        artistDAO = new ArtistDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String Email = request.getParameter("Email");
        String password = request.getParameter("password");

        Artist artist = new Artist();
        artist.setFname(fName);
        artist.setLname(lName);
        artist.setEmail(Email);
        artist.setPassword(password);
        try {
            artistDAO.registerArtist(artist);
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