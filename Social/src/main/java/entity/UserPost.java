package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="UserPost")
@NamedQuery(name="UserPost.findAll", query = "select uP from UserPost uP")
public class UserPost {
	@Id
	private int userPostID;
	private int userID;
	private String userPostText;
	private Date UserPostCreateTime;
	private boolean UserPostStatus;
	private Date userPostUpdateTime;
	
	// 1-nhiều giữa user và userpost
	@ManyToOne
    @JoinColumn(name="userID") //cart_id chính là trường khoá phụ trong table Item liên kết với khóa chính trong table Cart
    private UserEntity user;
	
	// 1-nhiều giữa userimage với userpost
	@OneToMany(mappedBy="uPost", fetch=FetchType.EAGER)
	private List<UserImage> uImages;
}
