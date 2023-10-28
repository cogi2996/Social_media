package vn.iotstar;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Group")
@NamedQuery(name="Group.findAll", query="SELECT c FROM Group c")
public class GroupEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	
	private int groupID;
	@Column(columnDefinition = "nvarchar(100) NOT NULL")
	private String groupName;
	@Column(columnDefinition = "NOT NULL")
	@Temporal(value = TemporalType.DATE)
	private Date createTime;
	@ManyToOne
	@JoinColumn(name="createrID")
	private UserEntity user;
	public GroupEntity() {
		super();
	}
	public GroupEntity(int groupID, String groupName, Date createTime, UserEntity user) {
		super();
		this.groupID = groupID;
		this.groupName = groupName;
		this.createTime = createTime;
		this.user = user;
	}
	public int getGroupID() {
		return groupID;
	}
	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
