package com.revature.pojo;

public class Client {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Boolean isSuper;
	
	
	//superUser Const
	public Client(String firstName, String lastName, String userName, String password, Boolean isSuper) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.isSuper = isSuper;
	}
	
	//Regular User const
	public Client(String firstName, String lastName, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
	}
	
	
	public Boolean getIsSuper() {
		return isSuper;
	}
	public void setIsSuper(Boolean isSuper) {
		this.isSuper = isSuper;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
