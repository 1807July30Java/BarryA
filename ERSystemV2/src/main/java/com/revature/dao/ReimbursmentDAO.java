package com.revature.dao;
import java.util.List;

import com.revature.pojo.*;

public interface ReimbursmentDAO {
	public boolean addReimbursment(Reimbursment reimb, double empId);
	public List<Reimbursment> viewAllResolved (String status);
	public List<Reimbursment> viewByManagerId (double managerID);
	public boolean resolveReimbursment(double empID, String status, double managerID);
	public List<Reimbursment> viewPending (double managerID, String status);
}
