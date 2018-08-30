package com.revature.logic;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.*;
import com.revature.pojo.*;


public class ServiceLink {
	EmployeeDAOImp empDAO = new EmployeeDAOImp();
	Employee emp = new Employee();
	ReimbursmentDAOImp reimbDAO = new ReimbursmentDAOImp();
	Reimbursment reimb = new Reimbursment();
	
	public boolean authenticateUser(String email, String password) {
		boolean test = false;
		if (email != null || password != null ) {
			test = empDAO.authenticate(email, password);
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
		String title = empDAO.getEmployeeInfo(email).getEmpTitle();
		return title ;
	}
	
	public boolean updateUser (String firstName, String lastName, String password, String email) {
		double id = empDAO.getEmployeeInfo(email).getEmpID();
		boolean result = false;
		
		if (empDAO.updateEmpFirstName(firstName, id) && empDAO.updateEmpLastName(lastName, id) && empDAO.updateEmpPassword(password, id) ) {
			System.out.println("Update Success!");
			result = true;
			
		}
		
		return result;
	}
	
	public double getManagerId(String email) {
		double id = empDAO.getEmployeeInfo(email).getManagerID();
		return id;
	}
	
	public boolean addEmployee(Employee emp) {
		if (empDAO.addEmployee(emp)) {
			return true;
		}
		return false;
	}
	public List<Employee> empByManager(String email){
		double id = empDAO.getEmployeeInfo(email).getEmpID();
		List<Employee> lemp = new ArrayList();
		
		lemp.addAll(empDAO.getEmployeeByManager(id));
		
		return lemp;
		
	}
	
/******************************************************************************************************************************************************************/
	//Reimbursment!!
	public boolean addReimb(String description, byte[] reimbEvidence, String email) {
	
			double empID = empDAO.getEmployeeInfo(email).getEmpID();
			Reimbursment objreimb = new Reimbursment(description, reimbEvidence);
			
			if (reimbDAO.addReimbursment(objreimb, empID)) {
				return true;
			}

		return false;
	}
	
	public List<Reimbursment> viewAppliedReimb(String email){
		double empID = empDAO.getEmployeeInfo(email).getEmpID();
		List<Reimbursment> view = new ArrayList();
		view.addAll(reimbDAO.employeeView(empID));
		
		return view;
	}

	public List<Reimbursment> viewAllTrans (){
		List<Reimbursment> li = new ArrayList();
		li.addAll(reimbDAO.viewEverything());
		return li;
	}
	
	public List<Reimbursment> viewByPending (String email){
		double managerID = empDAO.getEmployeeInfo(email).getEmpID();
		String status = "Pending...";
		List<Reimbursment> lp = new ArrayList();
		lp.addAll(reimbDAO.viewPending(managerID, status));
		return lp;
		
	}
	
	public boolean appDeny(double reimbID, String status, String email) {
		boolean result= false;
		double managerID = empDAO.getEmployeeInfo(email).getEmpID();
		if(reimbDAO.resolveReimbursment(reimbID, status, managerID)) {
			result = true;
		}
		return result;
	}
	
}
