package vn.iotstar;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


@WebServlet(urlPatterns = "/xulidangnhap")
public class XuLyDangNhap extends HttpServlet{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			BufferedReader reader = req.getReader();
			// Sử dụng thư viện Gson để phân tích JSON
			Gson gson = new Gson(); 
			// tạo obj giả nhằm lấy uid
			User user = gson.fromJson(reader, User.class);
			System.out.println(user);
			// tạo UserModel session đang dùng
			UserModel userSession = FindUser(user.getUid());
			// tạo session
			System.out.println("USER SESSION:"+userSession);
			HttpSession session = req.getSession();
			session.setAttribute("uid", userSession.getUid());
			session.setAttribute("username", userSession.getName());
			// Thiết lập thời gian tồn tại của phiên làm việc trong 5 phút
			session.setMaxInactiveInterval(60 * 5);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public UserModel FindUser (String uid) throws SQLException, IOException {
		String sql = "select uid,name from user where uid = ?";
		conn = new DBConnection().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, uid);
		rs = ps.executeQuery();
		while (rs.next()) {
			UserModel user = new UserModel();
			user.setUid(rs.getString(1));
			user.setName(rs.getString(2));
			conn.close();
			return user;
		}
		return null;
	}
}

class User {

    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

	@Override
	public String toString() {
		return "User [uid=" + uid + "]";
	}
}