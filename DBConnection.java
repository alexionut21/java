package licenta;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

		public static Connection getConnection(){
        //System.out.println("-------- Oracle JDBC Connection Testing ------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

           // System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
           

        }

        //System.out.println("Oracle JDBC Driver Registered!");

        Connection connection = null;

        try {

            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "alexionut", "alexionut21");

        } catch (SQLException e) {

            //System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            //return;

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
		return connection;
    }
}