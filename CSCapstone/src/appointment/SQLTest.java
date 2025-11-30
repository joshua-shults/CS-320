package appointment;

import java.sql.Connection;
import java.sql.DriverManager;

//This is for my instructor or interested party on GitHub to configure
//I personally used XAMPP for Apache and SQL as it was easiest to configure
//It is currently set up to run on default XAMPP SQL, just start Apache and SQL and this should connect
//Run this file to test connection
public class SQLTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cs_capstone", //I left this as default with XAMPP, if you make no changes it should connect
                    "root", //This is the username, if you want to use one change this here and in XAMPP settings
                    "" //This is the password, here its left intentionally blank as this application is an example
            );
            System.out.println("Connected: " + conn); //Prints this if successfully connected
        } catch (Exception e) {
            e.printStackTrace(); //Print stack trace for failed connection
        }
    }
}
