package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="UserImage")
@NamedQuery(name="UserImage.findAll", query = "select p from UserImage p")
public class UserImage {
	@Id
	private int userImageID;
	private int userPostID;
	private String userImageFile;
	
	// 1-nhiều giữa userimage với userpost
	@ManyToOne
    @JoinColumn(name="userPostID") //cart_id chính là trường khoá phụ trong table Item liên kết với khóa chính trong table Cart
    private UserPost uPost;
	
}
