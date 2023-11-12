package hcmute.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserPost")
@NamedQuery(name = "UserPost.findAll", query = "select uP from UserPost uP")
public class UserPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userPostID;
	private int userID;
	private String userPostText;
	private Date UserPostCreateTime;
	private boolean UserPostStatus;
	private Date userPostUpdateTime;

	//User đã đăng bài viết này.
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;


}
