package Team_13.CdacPortalWithQuiz.DTO;

import javax.persistence.Column;

import org.hibernate.annotations.Type;

import Team_13.CdacPortalWithQuiz.models.User;

public class LoginStatusDto {
	
	private int portalId;
	private String name;
	private String surname;
	private String email;
	private String role;
	private String profilePic;
	private boolean emailExist;
	private boolean password;
	private boolean active;
	public int getPortalId() {
		return portalId;
	}
	public void setPortalId(int portalId) {
		this.portalId = portalId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public boolean isEmailExist() {
		return emailExist;
	}
	public void setEmailExist(boolean emailExist) {
		this.emailExist = emailExist;
	}
	public boolean isPassword() {
		return password;
	}
	public void setPassword(boolean password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

	
}
