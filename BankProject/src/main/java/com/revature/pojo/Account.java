package com.revature.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Account {
	private String accountName;
	private Double currentBalance;
	private LocalDate creationDate;
	private LocalTime creationTime;
	
	//Constructor using fields
	
	public Account(String accountName, Double currentBalance) {
		super();
		this.accountName = accountName;
		this.currentBalance = currentBalance;
		this.creationDate = LocalDate.now();
		this.creationTime = LocalTime.now();
		
	}
	
	
	


}
