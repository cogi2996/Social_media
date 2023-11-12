package hcmute.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
@NamedQuery(name = "Account.findAll", query = "SELECT c FROM Account c")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int uid;
	private String gmail;
	private String userName;
	private String password;
	
	@OneToOne(mappedBy = "account")
	private User user;
	
}
