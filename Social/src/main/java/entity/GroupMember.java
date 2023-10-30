package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="GroupMember")
@NamedQuery(name="GroupMember.findAll", query = "select gmember from GroupMember gmember")


public class GroupMember implements Serializable{
	@Id
	private int groupID;
	
	private int userID;
	private int groupPostID;
	
    //primary key(groupID, userID, groupPostID),
	
	@ManyToOne
	@JoinColumn(name="groupPostID")
	private GroupPost grouppost;
}
