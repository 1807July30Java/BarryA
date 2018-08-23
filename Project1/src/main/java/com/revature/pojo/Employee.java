package com.revature.pojo;

public class Employee {
	
	private double empID;
	private String empFirstName;
	private String empLastName;
	private String empEmail;
	private String empPassword;
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
	
	public Employee(String empFirstName, String empLastName, String empEmail, String empPassword) {
		super();
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		
}

	public Employee(double empID, String empFirstName, String empLastName, String empEmail, String empPassword,
		double managerID) {
		super();
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.empPassword = empPassword;
		this.managerID = managerID;
}

	
	public Employee(double empID, String empFirstName, String empLastName, String empEmail, double managerID) {
		super();
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empEmail = empEmail;
		this.managerID = managerID;
}
	
	public Employee() {
		super();
	}
	
	
	

/************************************************************************/
	//Getters and Setters
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
/************************************************************************/
	//To string
	@Override
	public String toString() {
		return "Employee ID=" + empID + ", First Name: " + empFirstName + ", Last Name: " + empLastName
			+ ", Email: " + empEmail + ", Password: " + empPassword + ", Manager ID=" + managerID ;
	}






}
