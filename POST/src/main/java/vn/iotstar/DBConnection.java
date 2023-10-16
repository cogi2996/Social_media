package vn.iotstar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static String DB_URL = "jdbc:mysql://localhost:3306/socialmedia";
	private static String USER_NAME = "root"; // dùng trên máy cá nhân thì dùng root , còn sau này dùng trên host thì
												// mới được cấp cho một user name để dùng
	private static String PASSWORD = "29092003";
	// ba tham số này ban đầu nên được lưu vào một file properties , rồi ở dưới mới
	// đọc file để lấy tham số
	private static Connection con;

	public static Connection getConnection() throws IOException {
		con = null;
		try {
			// đăng kí driver mysql trong driver manager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			// kết nối driver mysql
			con =  (Connection)DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (SQLException ex) {
			// TODO: handle exception
			System.out.println("false");
		}
		return (con);
	}

}
