/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg134517;

/**
 *
 * @author PC
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import models.BankUser.AddBankUser;

public class RegistrationModel {

    public static String registerathlete(String athlete, String pass, String age, String gender, String event, String nationality, String contactinfo) {
        if (isathleteRegistered(athlete)) {
            return "User with the same credentials already exists. Please log in instead.";
        }

        try (Connection connection = DbConnection.getConnection()) {
            String query = "INSERT INTO logins (athlete, pass, age, gender, event, nationality, contactinfo) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, athlete);
            statement.setString(2, pass);
            statement.setString(3, age);
            statement.setString(4, gender);
            statement.setString(5, event);
            statement.setString(6, nationality);
            statement.setString(7, contactinfo);
            statement.executeUpdate();
            return "Athlete registered successfully!";
        } catch (SQLException ex) {
            return "Error registering user: " + ex.getMessage();
        }
        
    }

  


     public static boolean isathleteRegistered(String athlete) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DbConnection.getConnection();
            String query = "SELECT COUNT(*) FROM users WHERE email = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, athlete);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

   

