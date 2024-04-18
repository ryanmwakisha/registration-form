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
public final class Form {

    private String athlete, pass, age, gender, event, nationality, contactinfo;
    
   

    void doAdd() {
        //Check if username or password supplied
        if (athlete != null || pass!=null) {
   
            try {
                //Instantiate DbConnection class to use the connection
                DbConnection stayconnected = new DbConnection();
                stayconnected.doConnection();
                //Create the statement object for executing queries
                Statement stmt = stayconnected.con.createStatement();
                //Execute the statement
                stmt.executeUpdate("INSERT INTO logins VALUES('" + athlete + "','" + pass + "','" + age + "','" + gender + "','" + event + "','" + nationality + "','" + contactinfo + "')");
                System.out.println("athlete details added successfully \n");
                //Close the connection
                stayconnected.con.close();
            } catch (SQLException e) {
                System.out.println("Error! See below details \n");
                System.out.println(e);
            }
        } else {
            System.out.println("athlete or password can not be blank");
        }
    }

    public void setAthleteDetails(String Athlete, String password, String age, String gender, String event, String nationality, String contactinfo) {
        this.athlete = Athlete;
        this.pass = password;
        this.age = age;
        this.gender = gender;
        this.event = event;
        this.nationality = nationality;
        this.contactinfo = contactinfo;
        doAdd();
    }


}
