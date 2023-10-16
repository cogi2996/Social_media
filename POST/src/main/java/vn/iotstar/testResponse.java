package vn.iotstar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/dangnhapthanhcong")
public class testResponse extends HttpServlet {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
		rd.forward(req, resp);
		System.out.println("DANG NHAP THANH CONG");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// lấy list 3 bài viết 
		List<PostModel> list = findAllPost();
		System.out.println("List: "+list);
		req.setAttribute("listPost", list);
		RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
		rd.forward(req, resp);
		System.out.println("DANG NHAP THANH CONG");
	}

	private List<PostModel> findAllPost()
	{
		
		String sql = "select * from post order by post_id desc limit 3";
		List<PostModel> list = new ArrayList<PostModel>();
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				PostModel post = new PostModel();
				post.setPost_id(rs.getInt(1));
				post.setUid(rs.getString(2));
				post.setTitle(rs.getString(3));
				post.setContentPost(rs.getString(4));
				System.out.println("Post response : "+ post);
				System.out.println(post);
				list.add(post);
			}
			conn.close();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
