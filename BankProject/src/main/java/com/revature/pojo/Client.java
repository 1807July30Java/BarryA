package com.revature.pojo;

public class Client {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private boolean isSuper;
	private double userID;
	
	


	@Override
	public String toString() {
		return "Client firstName= " + firstName + ", lastName= " + lastName + ", userName= " + userName + ", password="
				+ password + ", userID= " + userID ;
	}

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
		this.isSuper = false;
	}
	
	
	public Client(double userID, String firstName, String lastName, String password,String username) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.isSuper = false;
		this.userID = userID;
		this.userName = username;
	}
	
	
	//Default Constructor here below
	
	public double getUserID() {
		return userID;
	}

	public void setUserID(double userID) {
		this.userID = userID;
	}

	public void setSuper(boolean isSuper) {
		this.isSuper = isSuper;
	}

	public Client() {
		super();
		this.firstName = null;
		this.lastName = null;
		this.userName = null;
		this.password = null;
		this.isSuper = false;
		
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
