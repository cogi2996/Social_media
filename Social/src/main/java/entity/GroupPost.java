package entity;

import java.io.Serializable;
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
import javax.swing.GroupLayout.Group;

@Entity
@Table(name="GroupPost")
@NamedQuery(name="GroupPost.findAll", query = "select p from GroupPost p")

public class GroupPost implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private int groupPostID;
	
	private String groupPostText;
	
	
	private Date groupPostCreateTime;
	private boolean groupPostStatus;
	private Date groupPostUpdateTime;
	
	// 1 nhiều với GroupImage
	@OneToMany(mappedBy="grPost", fetch=FetchType.EAGER)
	private List<GroupImage> grImages;
	
	// 1 nhiều với User
	@ManyToOne
    @JoinColumn(name="userID") //cart_id chính là trường khoá phụ trong table Item liên kết với khóa chính trong table Cart
    private UserEntity user;
	// 1 - n với group
	@ManyToOne
    @JoinColumn(name="groupID") 
	private GroupEntity group;
	
	
}
