package hcmute.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "User")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int userID;
	private String mobile;
	@Temporal(value = TemporalType.DATE)
	private Date createDate;
	@Temporal(value = TemporalType.DATE)
	private Date lastLogin;
	private String firstName;
	private String midName;
	private String lastName;
	private String address;
	private String biography;
	private String position;
	private String workPlace;
	private String avatar;

	// Các group được tạo bởi user.
	@OneToMany(mappedBy = "admin", fetch = FetchType.EAGER)
	private List<Group> createdGroup;

	// Các group mà user là thành viên.
	@ManyToMany
	@JoinTable(name = "GroupMember", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "groupID"))
	private List<Group> UserGroups;

	// Tài khoản đã cấp cho user.
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "uid")
	private Account account;

	// Các bài viết ( cá nhân ) của user.
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<UserPost> userPosts;

	// Các bài viết ( group ) của user.
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<GroupPost> groupPosts;

	// Những người user đã gửi follow.
	@ManyToMany
	@JoinTable(name = "Follow", joinColumns = @JoinColumn(name = "sourceID"), inverseJoinColumns = @JoinColumn(name = "targetID"))
	private List<User> followingUsers;

	// Những người follow user
	@ManyToMany(mappedBy = "followingUsers")
	private List<User> followers;

	// boxchat của user
	@OneToOne
	@JoinColumn(name = "boxChatID")
	private BoxChat boxChat;

}
