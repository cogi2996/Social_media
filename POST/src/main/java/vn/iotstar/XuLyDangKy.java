package vn.iotstar;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

@WebServlet(urlPatterns = "/xulidangky")
public class XuLyDangKy extends HttpServlet {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("here 1");
		try {
			System.out.println("here 2");
			BufferedReader reader = req.getReader();
			Gson gson = new Gson(); // Sử dụng thư viện Gson để phân tích JSON
			UserModel userModel = gson.fromJson(reader, UserModel.class);
			System.out.println(userModel);
			// insert dữ liệu vào database
			this.insert(userModel);

			HttpSession session = req.getSession();
			session.setAttribute("uid", userModel.getUid());
			session.setAttribute("username", userModel.getName());
			// Thiết lập thời gian tồn tại của phiên làm việc trong 5 phút
			session.setMaxInactiveInterval(60 * 5);

			/*
			 * RequestDispatcher rd = req.getRequestDispatcher("/home"); rd.forward(req,
			 * resp);
			 */ // Chuyển hướng đến trang readSession

//			resp.sendRedirect(req.getContextPath()+"/home.jsp");

		} catch (IOException | SQLException e) {
			System.out.println("ERRROR DO POST");
		}
	}

	public void insert(UserModel user) throws IOException, SQLException {
		String sql = "INSERT INTO user (uid, name, email, pass) VALUES (?, ?, ?,?)";
		conn = new DBConnection().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUid());
		ps.setString(2, user.getName());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPass());
		ps.executeUpdate();
	}
}
