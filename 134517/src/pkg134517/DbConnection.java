/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg134517;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class DbConnection {

    static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   //Declare a connection object
    Connection con;
    
    //Connection method. Returns the DB connection
    public void doConnection() {
        //Use try {...}catch(Exception e){} to test for any DB connection errors
        try {
            //STEP 1: Load the mysql driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //STEP 2: Create the database connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/athleteregistrationdb", "root", "");
            //Test if the connection is successful
            System.out.println("Database Connection successful");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection failed. See error below.");
            System.out.println(e);
        }
    }
}
