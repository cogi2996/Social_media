package vn.iotstar;

public class PostModel {
	private int post_id;
	private String uid;
	private String title;
	private String contentPost;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "PostModel [post_id=" + post_id + ", uid=" + uid + ", title=" + title + ", contentPost=" + contentPost
				+ "]";
	}
	public String getTitle() {
		return title;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
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
	
}
