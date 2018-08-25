package com.revature.logic;

import com.revature.dao.*;
import com.revature.pojo.*;

public class ServiceLink {
	EmployeeDAOImp empDAO = new EmployeeDAOImp();
	Employee emp = new Employee();
	
	public boolean authenticateUser(String email, String password) {
		boolean test = false;
		if (email != null || password != null ) {
			System.out.println(email +"--> "+ password);
			test = empDAO.authenticate(email, password);
			System.out.println("User validation is: " +test);
		}
		return test;
	}
	
	public String firstName (String email) {
		String name = empDAO.getEmployeeInfo(email).getEmpFirstName();
		return name;
	}
	public String lastName (String email) {
		String name = empDAO.getEmployeeInfo(email).getEmpLastName();
		return name;
	}
	
	public String getTitle (String email) {
		
		if (empDAO.getEmployeeInfo(email).getEmpID() == empDAO.getEmployeeInfo(email).getManagerID()) {
			return "Manager";
		}
		
		return "Employee";
	}

}
