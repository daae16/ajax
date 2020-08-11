package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	private static final String URL = "jdbc:oracle:thin:@localhost:1522/xe";
	private static final String ID = "c##test";
	private static final String PWD = "test";
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection open() {
		try {
			Connection con =  DriverManager.getConnection(URL, ID, PWD);
			con.setAutoCommit(false);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println("잘됨?");
		System.out.println(open());
		
	}
}
