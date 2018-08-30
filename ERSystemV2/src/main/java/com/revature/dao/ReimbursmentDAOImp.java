package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.pojo.*;

import com.revature.util.ConnectionUtil;

public class ReimbursmentDAOImp implements ReimbursmentDAO{
	private static String filename = "connection.properties";

	
	
	
	
/**************************************************************************************************************************************************************/
	@Override
	public boolean addReimbursment(Reimbursment reimb, double empId) {
		if (reimb == null) {
			return false;
		}
		
		EmployeeDAOImp eDao = new EmployeeDAOImp();
		double managerID = eDao.getEmployeeInfoById(empId).getManagerID();
	
		 PreparedStatement pstmt = null;
		 
		 try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
			 String sql = "INSERT INTO REIMBURSMENT (EMP_ID,REIMB_REASON,REIMB_EVIDENCE,REIMB_DATE_PROCESSED,MANAGER_ID) VALUES (?,?,?,?,?)";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setDouble(1, empId);
			 pstmt.setString(2, reimb.getReimbReason());
			 pstmt.setBytes(3, reimb.getReimbEvidence());
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 
			 pstmt.setString(4, formatter.format(reimb.getReimbProcessed()));
			 pstmt.setDouble(5, managerID);
		
			 if (pstmt.executeUpdate()>0) {
				return true;
			}
			 
		 } catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
/**************************************************************************************************************************************************************/

@Override
public List<Reimbursment> viewAllResolved(String status) {
	List<Reimbursment> lR = new ArrayList<>();
	
	
	PreparedStatement pstmt = null;	
	try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
		String sql = "SELECT * FROM REIMBURSMENT WHERE NOT REIMB_STATUS = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, status);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			double reimbID = rs.getDouble("REIMB_ID");
			double empID = rs.getDouble("EMP_ID");
			String reimbReason = rs.getString("REIMB_REASON");
			byte[] reimbEvidence = rs.getBytes("REIMB_EVIDENCE");
			String reimbProcessed = rs.getString("REIMB_DATE_PROCESSED");
			String reimbStatus = rs.getString("REIMB_STATUS");
			String reimbClosed = rs.getString("REIMB_DATE_CLOSED");
			String resolvedBy = rs.getString("RESOLVED_BY");
			
			lR.add(new Reimbursment(reimbID, reimbReason, reimbEvidence, reimbProcessed, reimbStatus, reimbClosed, empID,resolvedBy));
		}
	}catch (SQLException e) {
		return null;
		
	}catch (IOException e) {
		return null;
	}
	
	return lR;
}
/**************************************************************************************************************************************************************/

@Override
public List<Reimbursment> viewByManagerId(double managerID) {
List<Reimbursment> lR = new ArrayList<>();



	PreparedStatement pstmt = null;
	try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
		String sql = "SELECT * FROM REIMBURSMENT WHERE MANAGER_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, managerID);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			double reimbID = rs.getDouble("REIMB_ID");
			double empID = rs.getDouble("EMP_ID");
			String reimbReason = rs.getString("REIMB_REASON");
			byte[] reimbEvidence = rs.getBytes("REIMB_EVIDENCE");
			String reimbProcessed = rs.getString("REIMB_DATE_PROCESSED");
			String reimbStatus = rs.getString("REIMB_STATUS");
			String reimbClosed = rs.getString("REIMB_DATE_CLOSED");
			String resolvedBy = rs.getString("RESOLVED_BY");
			if (reimbClosed != null) {
				lR.add(new Reimbursment(reimbID, reimbReason, reimbEvidence, reimbProcessed, reimbStatus, reimbClosed, empID,resolvedBy));
			}else {
				lR.add(new  Reimbursment(reimbID, reimbReason, reimbEvidence, reimbProcessed, reimbStatus));			
				}

		}
	}catch (SQLException e) {
		return null;
		
	}catch (IOException e) {
		return null;
	}
	
	return lR;
}
/**************************************************************************************************************************************************************/

@Override
public boolean resolveReimbursment(double reimbID, String status, double managerID) {
	if (reimbID== 0 || status == null) {
		return false;
	} 
	EmployeeDAOImp obj = new EmployeeDAOImp();
	String resolvedBy = obj.getEmployeeInfoById(managerID).getEmpEmail();
	Date reimbClosed = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String dateClosed = formatter.format(reimbClosed);
	
	PreparedStatement pstmt = null;
	
	
	try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
		String sql = "UPDATE REIMBURSMENT SET REIMB_STATUS =? , REIMB_DATE_CLOSED=? , RESOLVED_BY=? WHERE REIMB_ID =?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,status);
		pstmt.setDouble(4, reimbID);
		pstmt.setString(2, dateClosed);
		pstmt.setString(3, resolvedBy);
		System.out.println("b4 if");
		if (pstmt.executeUpdate()>0) {
			
			return true;
		}
		
	} catch (SQLException | IOException e) {
		return false;
	}
	return false;

}
/**************************************************************************************************************************************************************/

@Override
public List<Reimbursment> viewPending(double managerID, String status) {
List<Reimbursment> lR = new ArrayList<>();
	if (status == null || managerID == 0) {
		return null;
	}
	PreparedStatement pstmt = null;
	
	try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
		
		String sql = "SELECT * FROM REIMBURSMENT WHERE REIMB_STATUS = ? AND MANAGER_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, status);
		pstmt.setDouble(2, managerID);
		ResultSet rs = pstmt.executeQuery();
		System.out.println("execute query");
		while (rs.next()) {
			double reimbID = rs.getDouble("REIMB_ID");
			double empID = rs.getDouble("EMP_ID");
			String reimbReason = rs.getString("REIMB_REASON");
			byte[] reimbEvidence = rs.getBytes("REIMB_EVIDENCE");
			String reimbProcessed = rs.getString("REIMB_DATE_PROCESSED");
			String reimbStatus = rs.getString("REIMB_STATUS");
			String reimbClosed = rs.getString("REIMB_DATE_CLOSED");
			String resolvedBy = rs.getString("RESOLVED_BY");
			if (reimbClosed != null) {
				lR.add(new Reimbursment(reimbID, reimbReason, reimbEvidence, reimbProcessed, reimbStatus, reimbClosed, empID,resolvedBy));
			}else {
				lR.add(new  Reimbursment(reimbID, reimbReason, reimbEvidence, reimbProcessed, reimbStatus,empID));			
				}		}
	}catch (SQLException e) {
		return null;
		
	}catch (IOException e) {
		return null;
	}
	
	return lR;
}
/**************************************************************************************************************************************************************/
/**************************************************************************************************************************************************************/

public List<Reimbursment> employeeView(double employeeID) {
List<Reimbursment> lR = new ArrayList<>();



	PreparedStatement pstmt = null;
	try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
		String sql = "SELECT * FROM REIMBURSMENT WHERE EMP_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, employeeID);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			double reimbID = rs.getDouble("REIMB_ID");
			double empID = employeeID;
			String reimbReason = rs.getString("REIMB_REASON");
			byte[] reimbEvidence = rs.getBytes("REIMB_EVIDENCE");
			String reimbProcessed = rs.getString("REIMB_DATE_PROCESSED");
			String reimbStatus = rs.getString("REIMB_STATUS");
			String reimbClosed = rs.getString("REIMB_DATE_CLOSED");
			String resolvedBy = rs.getString("RESOLVED_BY");
			if (reimbClosed != null) {
				lR.add(new Reimbursment(reimbID, reimbReason, reimbEvidence, reimbProcessed, reimbStatus, reimbClosed, empID,resolvedBy));
			}else {
				lR.add(new  Reimbursment(reimbID, reimbReason, reimbEvidence, reimbProcessed, reimbStatus, empID));			
				}

		}
	}catch (SQLException e) {
		return null;
		
	}catch (IOException e) {
		return null;
	}
	
	return lR;
}

/*****************************************************************************************************************************************************************/
public List<Reimbursment> viewEverything() {
	List<Reimbursment> lR = new ArrayList<>();
	
	
	
	try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){
		String sql = "SELECT * FROM REIMBURSMENT";
		Statement stmt = con.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			double reimbID = rs.getDouble("REIMB_ID");
			double empID = rs.getDouble("EMP_ID");
			String reimbReason = rs.getString("REIMB_REASON");
			byte[] reimbEvidence = rs.getBytes("REIMB_EVIDENCE");
			String reimbProcessed = rs.getString("REIMB_DATE_PROCESSED");
			String reimbStatus = rs.getString("REIMB_STATUS");
			String reimbClosed = rs.getString("REIMB_DATE_CLOSED");
			String resolvedBy = rs.getString("RESOLVED_BY");
			
			lR.add(new Reimbursment(reimbID, reimbReason, reimbEvidence, reimbProcessed, reimbStatus, reimbClosed, empID,resolvedBy));
		}
	}catch (SQLException e) {
		return null;
		
	}catch (IOException e) {
		return null;
	}
	
	return lR;
}
/*******************************************************************************************************************************************************************/
public byte[] getImage(double reimbID) {
	PreparedStatement pstmt = null;
	byte[] newObj = null;
	try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
		
		// use a prepared statement
		String sql = "SELECT REIMB_EVIDENCE FROM REIMBURSMENT WHERE REIMB_ID = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, reimbID);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			newObj = rs.getBytes("REIMB_EVIDENCE");
		}
		
		con.close();
		
	} catch (SQLException e) {
		System.out.println("Could not update database to decline ticket");
	} catch (IOException e) {
		e.printStackTrace();
	}
	return newObj;
}

}
