package com.revature.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Transactions {
	private double transactionID;
	private Date transactionTime;
	private String transactionDetail;
	private double beginBalance;
	private double endBalance;
	
	public Transactions(String transactionTime, String transactionDetail, double beginBalance, double endBalance,double transactionID) {
		super();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			this.transactionTime = formatter.parse(transactionTime);
		} catch (ParseException e) {
		System.out.println("Incorrect daate format");
			e.printStackTrace();
		}
		this.transactionDetail = transactionDetail;
		this.beginBalance = beginBalance;
		this.endBalance = endBalance;
		this.transactionID = transactionID;
	}
	
	

	public Transactions(String transactionDetail) {
		super();
		this.transactionDetail = transactionDetail;
		this.transactionTime = new Date();
	}



	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getTransactionDetail() {
		return transactionDetail;
	}

	public void setTransactionDetail(String transactionDetail) {
		this.transactionDetail = transactionDetail;
	}

	public double getBeginBalance() {
		return beginBalance;
	}

	public void setBeginBalance(double beginBalance) {
		this.beginBalance = beginBalance;
	}

	public double getEndBalance() {
		return endBalance;
	}

	public void setEndBalance(double endBalance) {
		this.endBalance = endBalance;
	}

	@Override
	public String toString() {
		return "Transactions [transactionTime=" + transactionTime + ", transactionDetail=" + transactionDetail
				+ ", beginBalance=" + beginBalance + ", endBalance=" + endBalance + "]";
	}

	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
