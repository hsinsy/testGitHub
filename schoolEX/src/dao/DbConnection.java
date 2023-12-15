package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	String name;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DbConnection.getDB());
	}
		
	public static Connection getDB() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/school";
		String user = "root";
		String password = "1234";
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			System.out.println("no driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}	
		return conn;
	}

}
