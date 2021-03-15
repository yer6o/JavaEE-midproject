package com.artistic.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.artistic.model.Artist;

public class ArtistDAO {

    public int registerArtist(Artist artist) throws ClassNotFoundException {
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/artist", "root", "741852963Aa1433");

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO artists (id, fname, lname, email, password) VALUES  (?, ?, ?, ?, ?);") ) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, artist.getFname());
            preparedStatement.setString(3, artist.getLname());
            preparedStatement.setString(4, artist.getEmail());
            preparedStatement.setString(5, artist.getPassword());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}