package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
        try {
        	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        	//TODO Trocar senha de acesso ao BD
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/ferramed", "root","root");  
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
}