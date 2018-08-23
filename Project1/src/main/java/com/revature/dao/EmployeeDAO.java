package com.revature.dao;

import java.util.List;

import com.revature.pojo.Employee;

public interface EmployeeDAO {
	public boolean authenticate(String email, String password);
	public List<Employee> getEmployeeByManager(double id);
	public Employee getEmployeeInfo(String email);
	public boolean updateEmpFirstName(String firstName, double id);
	public boolean updateEmpLastName(String lastName, double id);
	public boolean addEmployee(Employee emp, double managerId);
}
