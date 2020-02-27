package test;

import java.sql.*;

public class test1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Znaleziono driver bazy");
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlserver://LUKASZ;databaseName=wypozyczalnia", "lukasztom5", "avatar2010");
			System.out.println("Po³¹czony!!");
		}
		catch (ClassNotFoundException e) {
			System.out.println("Brak drivera");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("Brak po³¹czeniea");
			e.printStackTrace();
		}

	}

}
