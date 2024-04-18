/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg134517;

import java.sql.*;

/**
 *
 * @author PC
 */
public class UpdateForm {

    private String athlete,pass;
    Input goToUserList = new Input();

    void doUpdate() {
        //Check if username supplied
        if (athlete != null) {
            int numRows;
            try {
                //Instantiate DbConnection class to use the connection
                DbConnection stayconnected = new DbConnection();
                stayconnected.doConnection();
                //Create the statement object for executing queries
                Statement stmt = stayconnected.con.createStatement();
                //Execute the update statement and assigned number of affected rows to numRows
                numRows = stmt.executeUpdate("UPDATE logins SET password ='" + pass + "'WHERE athlete ='"+athlete+"'");
               
                if (numRows > 0) {
                    System.out.println("Password for"+athlete+" changed successfully");

                } else {
                    System.out.println("Password change failed. Try again");
                    goToUserList.doList();
                }
                //Close the connection
                stayconnected.con.close();
                goToUserList.doList();
            } catch (SQLException e) {
                System.out.println("Error! See below details \n");
                System.out.println(e);
            }
        } else {
            System.out.println("You must provide an athlete name to update user details");
        }
    }

    public void setUserDetails(String athlete,String pass) {
        this.athlete = athlete;
        this.pass = pass;
        doUpdate();
    }
}
