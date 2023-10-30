package entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Account")
@NamedQuery(name="Account.findAll", query="SELECT c FROM AccountEntity c")
public class AccountEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	
	private int uid;
	@Column(columnDefinition = "varchar(100) unique")
	private String gmail;
	@Column(columnDefinition = "varchar(50) NOT NULL")
	private String userName;
	@Column(columnDefinition = "varchar(100) NOT NULL")
	private String password;
	@OneToOne(mappedBy = "account")
	UserEntity user;
	public AccountEntity() {
		super();
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
