package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BoxChat")
@NamedQuery(name="BoxChat.findAll", query = "select p from BoxChat p")
public class BoxChat {
	@Id
	private int boxChatID;
	private int userID;
	
	// 1-nhiều giữa chat với chatbox
	@OneToMany(mappedBy="boxChat", fetch=FetchType.EAGER)
	private List<Chat> chats;
	
	// 1-1 giữa user với chatbox
	//cascade = CascadeType.ALL là khi xóa 1 dòng trong user thì boxchat sẽ tự xóa
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    private UserEntity users; // biến users này sẽ trùng  với giá trị  mappedBy trong Class UserEntity 

    
}


