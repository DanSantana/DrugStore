package ca.com.drugstore.factory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectionFactory {

	private static final String USUARIO = "root";
	private static final String SENHA = "Arthur2014";
	private static final String URL="jdbc:mysql://localhost:3306/drogaria";
	
	public static Connection openConnectio () throws SQLException{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());			
		
		Connection con = DriverManager.getConnection(URL, USUARIO, SENHA);
		return con;		
		}
	public static void main(String[] args) {
		try {
			Connection con = ConnectionFactory.openConnectio();
			System.out.println("Connected successfull!");
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			ex.getClass();
			System.out.println("was not possible connect to the server!");
		}		
	}
}
