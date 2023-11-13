package hcmute.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BoxChat")

public class BoxChat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boxChatID;
	private int userID;

	// user sở hữu boxchat
	@OneToOne(mappedBy = "boxChat")
	private User user;

	// các đoạn chat trong boxchat
	private List<GroupPost> groupPosts;
	@OneToMany(mappedBy = "boxChat", fetch = FetchType.EAGER)
	private List<Chat> chats;

	@Override
	public String toString() {
		return "BoxChat [boxChatID=" + boxChatID + ", userID=" + userID + "]";
	}

	public BoxChat(int boxChatID, int userID, User user, List<GroupPost> groupPosts, List<Chat> chats) {
		super();
		this.boxChatID = boxChatID;
		this.userID = userID;
		this.user = user;
		this.groupPosts = groupPosts;
		this.chats = chats;
	}

	public BoxChat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBoxChatID() {
		return boxChatID;
	}

	public void setBoxChatID(int boxChatID) {
		this.boxChatID = boxChatID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<GroupPost> getGroupPosts() {
		return groupPosts;
	}

	public void setGroupPosts(List<GroupPost> groupPosts) {
		this.groupPosts = groupPosts;
	}

	public List<Chat> getChats() {
		return chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

}
