package ers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import ers.enums.UserRoleEnum;

@Entity
@Table(name = "ers_user_roles")
public class UserRole {

	@Id
	@Enumerated(EnumType.STRING)
	@Column(name="user_role", length = 16)
	private UserRoleEnum role;
	
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public UserRoleEnum getRole() {
		return role;
	}

	public void setRole(UserRoleEnum role) {
		this.role = role;
	}

	
	
}
