package hcmute.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Chat")
@NamedQuery(name = "Chat.findAll", query = "select p from Chat p")
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chatID;
	private int boxChatID;

	// 1-nhiều giữa chat với chatbox
	@ManyToOne
	@JoinColumn(name = "boxChatID")
	private BoxChat boxChat;

	@Override
	public String toString() {
		return "Chat [chatID=" + chatID + ", boxChatID=" + boxChatID + "]";
	}

	public Chat(int chatID, int boxChatID, BoxChat boxChat) {
		super();
		this.chatID = chatID;
		this.boxChatID = boxChatID;
		this.boxChat = boxChat;
	}

	public Chat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getChatID() {
		return chatID;
	}

	public void setChatID(int chatID) {
		this.chatID = chatID;
	}

	public int getBoxChatID() {
		return boxChatID;
	}

	public void setBoxChatID(int boxChatID) {
		this.boxChatID = boxChatID;
	}

	public BoxChat getBoxChat() {
		return boxChat;
	}

	public void setBoxChat(BoxChat boxChat) {
		this.boxChat = boxChat;
	}

}
