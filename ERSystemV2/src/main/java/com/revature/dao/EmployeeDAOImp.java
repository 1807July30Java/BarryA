package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImp implements EmployeeDAO {
	private static String filename = "connection.properties";
/************************************************************************************************************************************************************/
	//Authentication Process
	@Override
	public boolean authenticate(String email, String password) {
	
		
		
		if (email == null || password == null) {
			return false;
		}
		
		
		Employee emp = new Employee() ;
		PreparedStatement pstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM EMPLOYEE WHERE EMP_EMAIL = ? AND EMP_PASSWORD= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
		if (rs.next()) {
			
			String empFirstName = rs.getString("EMP_FNAME");
			String empLastName = rs.getString("EMP_LNAME");
			String empEmail = rs.getString("EMP_EMAIL");
			String empPassword = rs.getString("EMP_PASSWORD");
			emp.setEmpEmail(empEmail);
			emp.setEmpFirstName(empFirstName);
			emp.setEmpLastName(empLastName);
			emp.setEmpPassword(empPassword);
			return true;
		}
			
		}catch (SQLException e) {	
			return false;
		}catch (IOException e) {
			return false;
		}
		
	
		return false;
	}
/************************************************************************************************************************************************************/
	//Retrieving Employee by manager ID
	@Override
	public List<Employee> getEmployeeByManager(double id) {
		List<Employee> lE = new ArrayList<>();
		PreparedStatement pstmt = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "SELECT * FROM EMPLOYEE WHERE MANAGER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				double empID = rs.getDouble("EMP_ID");
				String empFirstName = rs.getString("EMP_FNAME");
				String empLastName = rs.getString("EMP_LNAME");
				String empEmail = rs.getString("EMP_EMAIL");
				String empPassword = rs.getString("EMP_PASSWORD");
				String empTitle = rs.getString("EMP_TITLE");
				double managerID = rs.getDouble("MANAGER_ID");	
			lE.add(new Employee(empID, empFirstName, empLastName, empEmail, empPassword, managerID, empTitle));	
			}
		}catch (SQLException e) {
			return null;
			
		}catch (IOException e) {
			return null;
		}
		
		return lE;
	}
/************************************************************************************************************************************************************/
	//Employee Info after login
	@Override
	public Employee getEmployeeInfo(String email) {
		String email1 = email.toLowerCase();
		Employee emp = new Employee();
		if (email1 == null) {
			return null;
		}
		
		PreparedStatement pstmt = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			
			
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_EMAIL = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, email1);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			double empID = rs.getDouble("EMP_ID");
			String empFirstName = rs.getString("EMP_FNAME");
			String empLastName = rs.getString("EMP_LNAME");
			String empEmail = rs.getString("EMP_EMAIL");
			double managerID = rs.getDouble("MANAGER_ID");
			String empTitle = rs.getString("EMP_TITLE");
			
			emp = new Employee(empID,empFirstName, empLastName, empEmail, managerID, empTitle);
		}
		
			
		}catch (SQLException e) {
			return null;
		}catch (IOException e) {
			return null;
		}	
		
		return emp;
	}
/************************************************************************************************************************************************************/
	@Override
	public boolean updateEmpFirstName(String firstName, double id) {
		if (firstName== null ) {
			return false;
		} 
		PreparedStatement pstmt = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "UPDATE EMPLOYEE SET EMP_FNAME =? WHERE EMP_ID =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, firstName);
			pstmt.setDouble(2, id);
			if (pstmt.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return false;
	}
/************************************************************************************************************************************************************/
	@Override
	public boolean updateEmpLastName(String lastName, double id) {
		if (lastName== null ) {
			return false;
		} 
		PreparedStatement pstmt = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "UPDATE EMPLOYEE SET EMP_LNAME =? WHERE EMP_ID =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,lastName);
			pstmt.setDouble(2, id);
			if (pstmt.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException | IOException e) {
			return false;
		}
		return false;
	}
/************************************************************************************************************************************************************/
	public boolean addEmployee(Employee emp) {
		if (emp == null) {
			return false;
		}
		
		 PreparedStatement pstmt = null;
		 try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			 String sql = "INSERT INTO EMPLOYEE (EMP_FNAME,EMP_LNAME,EMP_EMAIL,EMP_PASSWORD, MANAGER_ID, EMP_TITLE) VALUES (?,?,?,?,?,?)";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setString(1, emp.getEmpFirstName());
			 pstmt.setString(2, emp.getEmpLastName());
			 pstmt.setString(3, emp.getEmpEmail());
			 pstmt.setString(4, emp.getEmpPassword());
			 pstmt.setDouble(5, emp.getManagerID());
			 pstmt.setString(6, emp.getEmpTitle());
			 
			 if (pstmt.executeUpdate()>0) {
				return true;
			}
			 
		 } catch (SQLException | IOException e) {
			return false;
		}
		
		return false;
	}
	
/***************************************************************************************************************************************************************/
	public boolean updateEmpPassword(String password, double id) {
		if (password== null ) {
			return false;
		} 
		PreparedStatement pstmt = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			String sql = "UPDATE EMPLOYEE SET EMP_PASSWORD =? WHERE EMP_ID =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,password);
			pstmt.setDouble(2, id);
			if (pstmt.executeUpdate()>0) {
				return true;
			}
			
		} catch (SQLException | IOException e) {
			return false;
		}
		return false;
	}
	
/***************************************************************************************************************************************************************/
	
	
	public Employee getEmployeeInfoById(double empId) {
		
		Employee emp = new Employee();
		if (empId == 0) {
			return null;
		}
		
		PreparedStatement pstmt = null;
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			
			
		String sql = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, empId);
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			double empID = rs.getDouble("EMP_ID");
			String empFirstName = rs.getString("EMP_FNAME");
			String empLastName = rs.getString("EMP_LNAME");
			String empEmail = rs.getString("EMP_EMAIL");
			double managerID = rs.getDouble("MANAGER_ID");
			String empTitle = rs.getString("EMP_TITLE");
			
			emp = new Employee(empID,empFirstName, empLastName, empEmail, managerID, empTitle);
		}
		
			
		}catch (SQLException e) {
			return null;
		}catch (IOException e) {
			return null;
		}	
		
		return emp;
	}
}
