package com.imc.database;
import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {
	public static Connection connection;
	
	public PostgreSQLJDBC(){
		Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/imc-calculator",
	            "postgres", "admin");
	         PostgreSQLJDBC.connection = c;
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		PostgreSQLJDBC.connection = connection;
	}
	
  
}