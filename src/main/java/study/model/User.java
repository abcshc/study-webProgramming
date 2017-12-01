package study.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;

	private String userId;
	private String password;
	private String email;
	private String name;
	
	public User() {
	}
	
	public User(String userId, String password, String email, String name) {
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.name = name;
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