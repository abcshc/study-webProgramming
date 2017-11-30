package study.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String userId;
	
	@Column
	private String password;

	@Column
	private String email;

	@Column
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void update(User updateUser) {
		this.name = updateUser.name;
		this.email = updateUser.email;
		this.password = updateUser.password;
		this.userId = updateUser.userId;
	}
}