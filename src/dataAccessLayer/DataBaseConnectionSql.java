package dataAccessLayer;

import java.sql.*;

public class DataBaseConnectionSql {
	
	static DataBaseConnectionSql instance = null;
	public static DataBaseConnectionSql getInstance() {
		if(instance == null) {instance = new DataBaseConnectionSql();}
		return instance;
	}
	
	private String connectionString = "jdbc:sqlserver://localhost:1433;Database=ToDoList;user=admin;password=pw";
	private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	private Connection connection = null;
	
	private DataBaseConnectionSql() {
		try {
			
			setConnection(DriverManager.getConnection(connectionString)); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
