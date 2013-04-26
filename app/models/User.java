package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;
import security.BCrypt;

@Entity
public class User extends Model{
	private String email;
	private String password;
	private String displayName;
	private Date date;
	private boolean activated;
	
	public User(String email, String password, String displayName, boolean activated) {
		this.email = email;
		setPassword(password);
		this.displayName = displayName;
		this.date = new Date();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		this.password = hashed;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
}
