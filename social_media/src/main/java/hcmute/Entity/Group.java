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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Group")
@NamedQuery(name = "Group.findAll", query = "SELECT c FROM Group c")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupID;
	private String groupName;
	@Temporal(value = TemporalType.DATE)
	private Date createTime;
	
	// admin của group
	@ManyToOne
	@JoinColumn(name = "userID")
	private User admin;
	
	// các thành viên trong group
	@ManyToMany(mappedBy = "UserGroups")
    private List<User> member;
	
	// 1 - n với grouppost
	@OneToMany(mappedBy = "group", fetch = FetchType.EAGER)
	private List<GroupPost> listPost;
	
	

}
