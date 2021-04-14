package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection databaseLink;

    public static Connection getConnection() {
        String DB_USER = "root";
        String DB_PASS = "root";
        String URL = "jdbc:mysql://localhost:3306/universiry?serverTimezone=Europe/Moscow&useSSL=false";

        try {
            databaseLink = DriverManager.getConnection(URL, DB_USER, DB_PASS);
        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        
        return databaseLink;
    }
}
