/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg134517;

//import com.mysql.cj.xdevapi.Statement;
import java.sql.*;
import java.util.Scanner;
import static pkg134517.Main.athlete;

/**
 *
 * @author PC
 */
import java.sql.*;

public class Login {

    static String authenticate(String athlete, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Constructor
    public Login() {
    }

    // Public method for login
    public void login(String athlete, String password) {
        // Call the private doLogin() method internally
        doLogin(athlete, password);
    }

    // Private method for performing login
    private void doLogin(String athlete, String password) {
        // Instantiate DBConnection class to begin DB connection
        DbConnection dBConnect = new DbConnection();
        dBConnect.doConnection();
        try {
            // Create a Statement object to help access query execution methods
            Statement stmt = dBConnect.con.createStatement();

            // Execute a SELECT query
            String selectQuery =  "SELECT * FROM logins WHERE athlete = '" + athlete + "' AND password = '" + password + "'";
            PreparedStatement preparedStatement = dBConnect.con.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the ResultSet
            if (resultSet.next()) {
                // Get database values and store them in local variables
                String dbAthlete = resultSet.getString("athlete");
                String dbPassword = resultSet.getString("password");
                // Compare with provided username and password
                if (dbAthlete.equalsIgnoreCase(athlete) && dbPassword.equals(password)) {
                    System.out.println("Login successful");
                } else {
                    System.out.println("Login failed. Incorrect username or password");
                }
            } else {
                System.out.println("Login failed. Incorrect username or password");
            }
            // Close the DB Connection when done using it
            dBConnect.con.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
}
