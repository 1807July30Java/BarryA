package com.revature.dao;

import java.sql.Date;
import java.util.List;

import com.revature.pojo.Transactions;

public interface BankTransactionDAO {
	public List<Transactions> getTransactionsByDate(Date date);//Transactions for a user between different dates
	public List<Transactions> getAllTransactions(double accountID,String username); //All Transactions for a user
	public boolean addIncrementingTrans(Transactions trans, double balance, double accountID, String username);
	public boolean addDecrementingTrans(Transactions trans, double balance, double accountID, String username);
}
