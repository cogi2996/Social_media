package vn.iotstar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
@WebServlet(urlPatterns = "/createNewPost")
public class InsertPost extends HttpServlet{
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = req.getReader();
		// Sử dụng thư viện Gson để phân tích JSON
		Gson gson = new Gson(); 
		// tạo obj giả nhằm lấy uid
		post post = gson.fromJson(reader, post.class);
		System.out.println(post);
		// insert database uid 's post
		HttpSession session = req.getSession();
		String uid = (String)session.getAttribute("uid");
		if(session!=null)
		{
			PostModel newPost = new PostModel();
			newPost.setUid(uid);
			newPost.setTitle(post.getTitle());
			newPost.setContentPost(post.getContentPost());
			// insert vào mysql
			this.insert(newPost);
			// response client post model
			PostModel postModel = getUserNewPost(newPost.getUid());
			System.out.println("POST MODEL RESPONSE :"+ postModel);
			System.out.println("UID POST:"+newPost.getUid());
			// return json bài viết mới đăng cho client 
			String PostJsonString = new Gson().toJson(postModel);
			PrintWriter out = resp.getWriter();
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");	
			out.print(PostJsonString);
			out.flush();
			// 
		}
	}
	private PostModel getUserNewPost(String uid)
	{
		String sql = "select *\r\n"
				+ "from post \r\n"
				+ "where uid = ?\r\n"
				+ "order by post_id desc\r\n"
				+ "LIMIT 1;";
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				PostModel post = new PostModel();
				post.setPost_id(rs.getInt(1));
				post.setUid(rs.getString(2));
				post.setTitle(rs.getString(3));
				post.setContentPost(rs.getString(4));
				System.out.println("Post response : "+ post);
				conn.close();
				return post;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	private void insert(PostModel newPost) {
		String sql = "insert into post (uid,title,contentPost) values (?,?,?)";
		
		try {
			conn = new DBConnection().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPost.getUid());
			ps.setString(2,newPost.getTitle());
			ps.setString(3, newPost.getContentPost());
			ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

class post{
	private String title;
	private String contentPost;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentPost() {
		return contentPost;
	}
	public void setContentPost(String contentPost) {
		this.contentPost = contentPost;
	}
	@Override
	public String toString() {
		return "post [title=" + title + ", contentPost=" + contentPost + "]";
	}
	
}