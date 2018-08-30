package com.revature.pojo;

public class Employee {
	
	private double empID;
	private String empFirstName;
	private String empLastName;
	private String empEmail;
	private String empPassword;
	private String empTitle;
	private double managerID;
	
/************************************************************************/
//Constructors	
	
	public Employee(String empFirstName, String empLastName, String empEmail, String empPassword, double managerID) {
		super();
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.managerID = managerID;
}
	
	public Employee(String empFirstName, String empLastName, String empEmail, String empPassword, String empTitle, double managerID) {
		super();
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.empTitle = empTitle;
		this.managerID = managerID;
}

	public Employee(double empID, String empFirstName, String empLastName, String empEmail, String empPassword,
		double managerID, String empTitle) {
		super();
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.managerID = managerID;
		this.empTitle = empTitle;
}

	
	public Employee(double empID, String empFirstName, String empLastName, String empEmail, double managerID, String empTitle) {
		super();
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.managerID = managerID;
		this. empTitle = empTitle;
}
	
	

	public Employee() {
		super();
	}
	
	
	

/************************************************************************/
	//Getters and Setters
	
	public String getEmpTitle() {
		return empTitle;
	}

	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}
	public double getEmpID() {
		return empID;
	}
	public void setEmpID(double empID) {
		this.empID = empID;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public double getManagerID() {
		return managerID;
	}
	public void setManagerID(double managerID) {
		this.managerID = managerID;
	}
@Override
public String toString() {
	return "ID=" + empID + ", First Name: " + empFirstName + ", Last Name: " + empLastName
			+ ", Email: " + empEmail + ", Password: " + empPassword + ", Title: " + empTitle + ", managerID: "
			+ managerID ;
}






}
