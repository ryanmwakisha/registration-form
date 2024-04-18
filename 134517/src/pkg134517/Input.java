/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg134517;

import static pkg134517.Main.main;
import java.sql.*;
import java.util.*;


/**
 *
 * @author PC
 */
public class Input {

    private String athlete, passHere;
    int choiceHere;

    void doList() {
        //Check if username or password supplied
        try {
            //Instantiate DbConnection class to use the connection
            DbConnection dBConnect = new DbConnection();
            dBConnect.doConnection();
            //Create the statement object for executing queries
            Statement stmt = dBConnect.con.createStatement();
            //Execute the statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM logins");
            //Handle the results set
            System.out.format("%s, %s\n", "athlete", "event");
            while (rs.next()) {
                //System.out.println("User "+userNumber);
                System.out.format("%s, %s\n", rs.getString("athlete"), rs.getString("event"));
            }
            //Close the connection
            dBConnect.con.close();
            beginAfterView();
        } catch (SQLException e) {
            System.out.println("Error! See below details \n");
            System.out.println(e);
        }
    }

    void beginAfterView() {
        //Ask the user what to do
        Scanner sc = new Scanner(System.in);
        System.out.println("Do more: ");
        System.out.println("Enter 1 to Update form details.");
        System.out.println("Enter 2 to Logout an athlete.");
        choiceHere = sc.nextInt();
        
        switch (choiceHere) {
            case 1:
                System.out.println("...Update User...");
                System.out.println("Enter athlete to select: ");
                athlete = sc.nextLine();
                System.out.println("Enter a new password for user "+athlete+"");
                passHere = sc.nextLine();
                //Jump to UpdateUser.java
                UpdateForm updateUserObject = new UpdateForm();
                updateUserObject.setUserDetails(athlete, passHere);
                break;
            case 2:
                 System.out.println("You are now logged out...");
                main(null);
                break;               
            default:
                System.out.println("Invalid choice");
                beginAfterView();
                break;
        }
    }
}
