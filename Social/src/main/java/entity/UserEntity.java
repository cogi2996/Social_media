package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "User")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id

	private int userID;
	@Column(columnDefinition = "varchar(11)")
	private String mobile;
	@Column(columnDefinition = "NOT NULL")
	@Temporal(value = TemporalType.DATE)
	private Date createDate;
	@Column(columnDefinition = "NOT NULL")
	@Temporal(value = TemporalType.DATE)
	private Date lastLogin;
	@Column(columnDefinition = "nvarchar(50) NOT NULL")
	private String firstName;
	@Column(columnDefinition = "nvarchar(50)")
	private String midName;
	@Column(columnDefinition = "nvarchar(50) NOT NULL")
	private String lastName;
	@Column(columnDefinition = "nvarchar(200)")
	private String address;
	@Column(columnDefinition = "nvarchar(MAX)")
	private String biography;
	@Column(columnDefinition = "nvarchar(100)")
	private String position;
	@Column(columnDefinition = "nvarchar(200)")
	private String workPlace;
	@Column(columnDefinition = "text")
	private String avatar;
	@Column(columnDefinition = "text")
	private String cover;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<GroupEntity> group;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	private AccountEntity account;

	// 1-nhiều giữa user và userpost
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<UserPost> uPosts;

	// 1-1 giữa user với chatbox
	@OneToOne(mappedBy = "users")
	private BoxChat boxChat;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<GroupPost> groupPosts;

	public UserEntity() {
		super();
	}

	public UserEntity(int userID, String mobile, Date createDate, Date lastLogin, String firstName, String midName,
			String lastName, String address, String biography, String position, String workPlace, String avatar,
			String cover, AccountEntity account) {
		super();
		this.userID = userID;
		this.mobile = mobile;
		this.createDate = createDate;
		this.lastLogin = lastLogin;
		this.firstName = firstName;
		this.midName = midName;
		this.lastName = lastName;
		this.address = address;
		this.biography = biography;
		this.position = position;
		this.workPlace = workPlace;
		this.avatar = avatar;
		this.cover = cover;
		this.account = account;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}
}
