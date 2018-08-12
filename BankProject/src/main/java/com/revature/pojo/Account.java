package com.revature.pojo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Account {
	private String accountName;
	private double currentBalance;
	private Date creationDate;
	private double accountID;
	
	
	//Constructor using fields
	public Account(String accountName, double currentBalance) {
		super();
		this.accountName = accountName;
		this.currentBalance = currentBalance;
		this.creationDate = new Date();
		
	}
	
	public Account(String accountName, double currentBalance,double accountID) {
		super();
		this.accountName = accountName;
		this.currentBalance = currentBalance;
		this.creationDate = new Date();
		this.accountID = accountID;
		
	}

	public Account(String accountName, double currentBalance,double accountID,String creationDate) {
		super();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.accountName = accountName;
		this.currentBalance = currentBalance;
		this.accountID = accountID;
		try {
			this.creationDate = formatter.parse(creationDate);
		} catch (ParseException e) {
		System.out.println("Incorrect date format");
			e.printStackTrace();
		}
		
	}
	
	public Account() {
		super();
		
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getAccountID() {
		return accountID;
	}

	public void setAccountID(double accountID) {
		this.accountID = accountID;
	}

	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", currentBalance=" + currentBalance + ", creationDate="
				+ creationDate + ", accountID=" + accountID + "]";
	}
	
	


}
