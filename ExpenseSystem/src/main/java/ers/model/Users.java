package ers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ers_users")
public class Users {

	@Column(name = "user_firstname", nullable = false)
	private String fname;
	@Column(name = "user_lastname", nullable = false)
	private String lname;
	@Id
	@Column(name = "ers_username", nullable = false)
	private String uname;
	@Column(name = "ers_password", nullable = false)
	private String password;
	@Column(name = "user_email", nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(name = "user_role", referencedColumnName = "user_role")
	private UserRole role;

	public Users(String fname, String lname, String uname, String password, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.password = password;
		this.email = email;
	}

	public Users(String fname, String lname, String uname, String password, String email, UserRole role) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public Users() {
		super();
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", password=" + password + ", email="
				+ email + "]";
	}

}