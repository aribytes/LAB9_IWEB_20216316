package org.example.lab9_iweb_20216316;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL ="jdbc:mysql://localhost:3306/lab9_biblioteca";
    private static final String USER ="root";
    private static final String PASSWORD = "1029";
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
