package com.revature.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.omg.CosNaming.BindingIterator;

public class Reimbursment {

	private double reimbID;
	private String reimbReason;
	private byte[] reimbEvidence;
	private Date reimbProcessed;
	private String reimbProcessedString;
	private String reimbStatus;
	private Date reimbClosed;
	private String reimbClosedString;
	private double empID;
	private String resolvedBy;
/**********************************************************************************************************************************************************/
	//Constructors
	public Reimbursment() {
		super();
		// TODO Auto-generated constructor stub
	}	
public Reimbursment(String reimbReason, byte[] reimbEvidence) {
	super();
	this.reimbReason = reimbReason;
	this.reimbEvidence = reimbEvidence;
	this.reimbProcessed = new Date();
}
	

	
public Reimbursment(double reimbID, String reimbReason, byte[] reimbEvidence, String reimbProcessed, String reimbStatus,
		String reimbClosed) {
	super();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	this.reimbID = reimbID;
	this.reimbReason = reimbReason;
	this.reimbEvidence = reimbEvidence;
	this.reimbStatus = reimbStatus;
	
	if (reimbClosed != null) {
		try {
			this.reimbProcessed = formatter.parse(reimbProcessed);
			this.reimbClosed = formatter.parse(reimbClosed);
		} catch (ParseException e) {
			System.out.println("Enter Valid Date");
		}
	}else {
		try {
			this.reimbProcessed = formatter.parse(reimbProcessed);
		} catch (ParseException e) {
			System.out.println("Enter Valid Date");
		}
	}
	
	
	
}
@Override
public String toString() {
	return "Reimbursment reimbID= " + reimbID + ", reimbReason= " + reimbReason + ", reimbEvidence="
			+ Arrays.toString(reimbEvidence) + ", reimbProcessed= " + reimbProcessed + ", reimbStatus= " + reimbStatus
			+ ", reimbClosed= " + reimbClosed + ", empID=" + empID + "]";
}


public Reimbursment(double reimbID, String reimbReason, byte[] reimbEvidence, String reimbProcessed, String reimbStatus,
		String reimbClosed, double empID, String resolvedBy) {
	super();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	this.reimbID = reimbID;
	this.reimbReason = reimbReason;
	this.reimbEvidence = reimbEvidence;
	this.reimbStatus = reimbStatus;
	this.reimbProcessedString = reimbProcessed;
	this.reimbClosedString = reimbClosed;
	this.empID = empID;
	this.resolvedBy = resolvedBy;
	
}
public Reimbursment(double reimbID, String reimbReason, byte[] reimbEvidence, String reimbProcessed, String reimbStatus,
		 double empID) {
	super();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	this.reimbID = reimbID;
	this.reimbReason = reimbReason;
	this.reimbEvidence = reimbEvidence;
	this.reimbStatus = reimbStatus;
	this.reimbProcessedString = reimbProcessed;
	this.empID = empID;
	
}


public String getReimbProcessedString() {
	return reimbProcessedString;
}
public void setReimbProcessedString(String reimbProcessedString) {
	this.reimbProcessedString = reimbProcessedString;
}
public String getReimbClosedString() {
	return reimbClosedString;
}
public void setReimbClosedString(String reimbClosedString) {
	this.reimbClosedString = reimbClosedString;
}
public Reimbursment(double reimbID, String reimbReason, byte[] reimbEvidence, String reimbProcessed, String reimbStatus) {
	super();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	this.reimbID = reimbID;
	this.reimbReason = reimbReason;
	this.reimbEvidence = reimbEvidence;
	this.reimbStatus = reimbStatus;
	try {
		this.reimbProcessed = formatter.parse(reimbProcessed);
	} catch (ParseException e) {
		System.out.println("Enter Valid Date");
	}
	
	
}



public double getEmpID() {
	return empID;
}
public void setEmpID(double empID) {
	this.empID = empID;
}
/**********************************************************************************************************************************************************/
	//Getters and Setters


public String getResolvedBy() {
	return resolvedBy;
}
public void setResolvedBy(String resolvedBy) {
	this.resolvedBy = resolvedBy;
}
	public double getReimbID() {
		return reimbID;
	}

	public void setReimbID(double reimbID) {
		this.reimbID = reimbID;
	}
	public String getReimbReason() {
		return reimbReason;
	}
	public void setReimbReason(String reimbReason) {
		this.reimbReason = reimbReason;
	}
	public byte[] getReimbEvidence() {
		return reimbEvidence;
	}
	public void setReimbEvidence(byte[] reimbEvidence) {
		this.reimbEvidence = reimbEvidence;
	}
	public Date getReimbProcessed() {
		return reimbProcessed;
	}
	public void setReimbProcessed(Date reimbProcessed) {
		this.reimbProcessed = reimbProcessed;
	}
	public String getReimbStatus() {
		return reimbStatus;
	}
	public void setReimbStatus(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}
	public Date getReimbClosed() {
		return reimbClosed;
	}
	public void setReimbClosed(Date reimbClosed) {
		this.reimbClosed = reimbClosed;
	}
	
	/**********************************************************************************************************************************************************/
	

}
