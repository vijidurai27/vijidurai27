package com.Smart.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "USER")
public class User 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
    
    @NotBlank(message = "Name field is required !!")
    @Size(min=2, max = 20, message = "minimum 2 and maximum 20 characters are allowed !!")
    private String userName;
    
    
    
    @Column(unique = true)
    @NonNull
	private String userEmail;
    
    @Column
	private String userPassword;
    
    @Column
	private String userRole;
    
    @Column
	private boolean userEnabled;
    
    @Column
	private String userImageUrl;
    
    @Column(length = 500)
	private String userAbout;
    
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Contact> contacts = new ArrayList<>();

	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public String getUserRole() {
		return userRole;
	}



	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	public boolean isUserEnabled() {
		return userEnabled;
	}



	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}



	public String getUserImageUrl() {
		return userImageUrl;
	}



	public void setUserImageUrl(String userImageUrl) {
		this.userImageUrl = userImageUrl;
	}



	public String getUserAbout() {
		return userAbout;
	}



	public void setUserAbout(String userAbout) {
		this.userAbout = userAbout;
	}



	public List<Contact> getContacts() {
		return contacts;
	}



	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}





	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userRole=" + userRole + ", userEnabled=" + userEnabled + ", userImageUrl="
				+ userImageUrl + ", userAbout=" + userAbout + ", contacts=" + contacts + "]";
	}



	public User(int userId, String userName, String userEmail, String userPassword, String userRole,
			boolean userEnabled, String userImageUrl, String userAbout, List<Contact> contacts) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userEnabled = userEnabled;
		this.userImageUrl = userImageUrl;
		this.userAbout = userAbout;
		this.contacts = contacts;
	}

	
}
