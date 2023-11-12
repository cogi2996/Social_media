package hcmute.Entity;

import java.io.Serializable;
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
@Table(name = "GroupPost")
@NamedQuery(name = "GroupPost.findAll", query = "select p from GroupPost p")

public class GroupPost implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupPostID;
	private String groupPostText;
	private Date groupPostCreateTime;
	private boolean groupPostStatus;
	private Date groupPostUpdateTime;


	// Các bài viết của user đã đăng
	@ManyToOne
	@JoinColumn(name = "userID")
	private User user;
	
	// 1 - n với group
	@ManyToOne
	@JoinColumn(name = "groupID")
	private Group group;

}
