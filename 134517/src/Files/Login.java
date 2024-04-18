/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Files;

//import com.mysql.cj.xdevapi.Statement;
import java.sql.*;

/**
 *
 * @author pc
 */
public class Login {

//Member variable decalaration
    //Constructor
        public void doLogin(String uName, String pass) {
        //Instantiate DBConnection class to begin DB connection
       DBconnection dBConnect = new DBconnection();
       dBConnect.doConnection();
        try {
            //STEP 3. CREATE a Statement object to help access querry execution methods
            Statement stmt = dBConnect.con.createStatement();

            //STEP 4. Execute SQL Query
            // Execute a SELECT query
            String selectQuery = "SELECT * FROM users";
            ResultSet resultSet = stmt.executeQuery(selectQuery);

            //STEP 5. Process the resultset
            // Process the ResultSet
            if (resultSet.next()) {
                //Get database values and store them in local variables
                String dbusername = resultSet.getString("username");
                String dbpassword = resultSet.getString("password");
                String role = resultSet.getString("role");
                if (uName.equalsIgnoreCase(dbusername) && pass.equals(dbpassword)) {
                    System.out.println("Login successful");
                    System.out.println("Write the logic for next actions here");
                } else {
                    System.out.println("Login failed. Incorrect username or password");
                }
            }
            //STEP 6. Close the DB Connection when done using it
            dBConnect.con.close();
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }

}
