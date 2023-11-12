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
	@OneToMany(mappedBy = "boxChat",fetch = FetchType.EAGER)
	private List<Chat> chats;
	
}
