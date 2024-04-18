/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg134517;

import java.util.*;

/**
 *
 * @author PC
 * 
 */
public class Main{

    static String athlete, pass, age, gender, event, nationality, contactinfo;
    static int choice;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        begin();
    }

    static void begin() {
        //Ask the user what to do
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose what to do:");
        System.out.println("Enter 1 to login.");
        System.out.println("Enter 2 to register a user.");
        System.out.println("Enter 3 to Input");
        choice = sc.nextInt();
        
        if (choice == 2) {
            System.out.println("...User Registration...");
            
            System.out.println("Please enter a username: ");
            athlete = sc.nextLine();          
            System.out.println("Please enter a password: ");
            pass = sc.nextLine();           
            System.out.println("Please enter your age");
            age = sc.nextLine();
            System.out.println("Please enter your gender");
            gender = sc.nextLine();
            System.out.println("Please enter your event");
            event =sc.nextLine();
            System.out.println("Please enter your nationality");
            nationality = sc.nextLine();
            System.out.println("Please enter your contactinfo");
            contactinfo = sc.nextLine();
            
            //Jump to AddUser.java
            Form adduserobject = new Form();
            adduserobject.setAthleteDetails(athlete, pass, age, gender, event, nationality, contactinfo);
            
        }if (choice == 3){
            Input inputUser = new Input();
            inputUser.beginAfterView();
            
        
        }else if (choice == 1) {
            System.out.println("...User Login...");
            System.out.println("Enter login username: ");
            athlete = sc.nextLine();
            System.out.println("Enter login password: ");
            pass = sc.nextLine();
            //Jump to Login.java
            Login loginObject = new Login();
            loginObject.login(athlete,pass);
        } else {
            System.out.println("Invalid choice");
            main(null);
        }
    }
}
