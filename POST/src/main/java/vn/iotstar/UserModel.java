package vn.iotstar;

public class UserModel {
	private String uid; // Lưu ý: Không nên lưu trữ mật khẩu trong đối tượng UserModel.
    private String email;
    private String name;
    private String pass;
	
	public String getUid() {
		return uid; 
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "UserModel [uid=" + uid + ", email=" + email + ", name=" + name + ", pass=" + pass + "]";
	}
	
	

   
}

