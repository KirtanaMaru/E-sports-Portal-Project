package app.com.pojos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "eventmanager_login")
public class EventManager extends BaseEntity {

	private String email;
	private String name;
	private String password;
	private String status;
	public EventManager() {
		super();
	}
	public EventManager(String email, String name, String password, String status) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "EventManager [email=" + email + ", name=" + name + ", password=" + password + ", status=" + status
				+ "]";
	}
	
	
}
