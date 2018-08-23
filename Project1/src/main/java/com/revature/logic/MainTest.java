package com.revature.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.EmployeeDAOImp;
import com.revature.pojo.Employee;
import com.revature.util.ConnectionUtil;

public class MainTest {

	public static void main(String[] args) {
		EmployeeDAOImp obj = new EmployeeDAOImp();
		String email = "admin@breimb.com";
		String password = "password";
		
		Employee emp = new Employee( "Papa"	, "Omar", "dummyentry@breimb.com","password");

		System.out.println(obj.authenticate(email, password));
		for (Employee empp : obj.getEmployeeByManager(2)) {
			System.out.println(empp);
		}
		
		
	

	}

}
