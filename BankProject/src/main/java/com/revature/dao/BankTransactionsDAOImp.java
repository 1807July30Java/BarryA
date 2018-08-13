package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.*;
import com.revature.util.ConnectionUtil;

public class BankTransactionsDAOImp implements BankTransactionDAO{
	private String filename = "connectionProperties";
	

	public List<Transactions> getTransactionsByDate(Date date) {
		
		return null;
	}

	/***********************************************************************************************************************************************/
	
	//Get Transactions from a specific account
	
	public List<Transactions> getAllTransactions(double accountID, String username) {
		BankAccountDAOImp obj = new BankAccountDAOImp();
		List <Transactions> tr = new ArrayList<>();
		List<Account> ac = new ArrayList<>();
		ac.addAll(obj.getAccount(username));
	
		
		PreparedStatement pstmt = null;
		
		
		for (Account a : ac) {
			if (a.getAccountID()!= accountID) {
				System.out.println("Incorrect account ID");
				System.out.println("Please try again");
				return null;
			}
		}
		
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			String sql = "SELECT * FROM BANK_TRANSACTIONS WHERE ACCOUNT_ID= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, accountID);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()){
				double account_ID = rs.getDouble("ACCOUNT_ID");
				double transactionID = rs.getDouble("TRANSACTION_ID");
				String transactionDetail = rs.getString("TRANS_DESCRIPTION");
				double beginBalance = rs.getDouble("PRE_TRANS_BALANCE");
				double endBalance = rs.getDouble("POST_TRANS_BALANCE");
				String transactionTime = rs.getString("TRANS_TIME");
				
				tr.add(new Transactions(transactionTime, transactionDetail, beginBalance, endBalance, transactionID));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (Transactions tr1 : tr) {
			System.out.println(tr1);
		}
		return tr;
	}
	
	/*****************************************************************************************************************/
//Depositing money.
	@Override
	public boolean addIncrementingTrans(Transactions trans, double balance, double accountID, String username) {
		BankAccountDAOImp ac = new BankAccountDAOImp();
		
		if (ac.getAccountByAccountID(accountID, username)== null) {
			return false;
		}
		
		double beginBalance = ac.getAccountByAccountID(accountID, username).getCurrentBalance();
		
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "INSERT INTO BANK_TRANSACTIONS (TRANS_DESCRIPTION, PRE_TRANS_BALANCE, POST_TRANS_BALANCE, ACCOUNT_ID,TRANS_TIME) VALUES (?, ?, ?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, trans.getTransactionDetail());
			pstmt.setDouble(2, beginBalance);
			pstmt.setDouble(3, (beginBalance+balance));
			pstmt.setDouble(4, accountID);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pstmt.setString(5, formatter.format(trans.getTransactionTime()));
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Transaction successfull!");
				 ac.updateAccountBalance(accountID, (beginBalance+balance));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/***********************************************************************************************************************************************/
	
// Performing Transaction
	@Override
	public boolean addDecrementingTrans(Transactions trans, double balance, double accountID, String username) {
		BankAccountDAOImp ac = new BankAccountDAOImp();
		
		if (ac.getAccountByAccountID(accountID, username)== null) {
			return false;
		}
		double beginBalance = ac.getAccountByAccountID(accountID, username).getCurrentBalance();
		
		if (beginBalance - balance <0) {
			System.out.println("Not enough funds in your account. Please deposit more funds to perform this operation");
			System.out.println("Current balance = $"+beginBalance);
			
			return false;
		}
		
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "INSERT INTO BANK_TRANSACTIONS (TRANS_DESCRIPTION, PRE_TRANS_BALANCE, POST_TRANS_BALANCE, ACCOUNT_ID,TRANS_TIME) VALUES (?, ?, ?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, trans.getTransactionDetail());
			pstmt.setDouble(2, beginBalance);
			pstmt.setDouble(3, (beginBalance-balance));
			pstmt.setDouble(4, accountID);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pstmt.setString(5, formatter.format(trans.getTransactionTime()));
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Transaction successfull!");
				 ac.updateAccountBalance(accountID, (beginBalance-balance));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	/***********************************************************************************************************************************************/
//Deleting Transactions by userID
	public boolean deleteTransactiontByUser(String username) {
		if (username == null) {
			System.out.println(("Enter a Valid username and try again"));
			return false;
		}
		List<Account> ac = new ArrayList<>();
			
		BankAccountDAOImp obj = new BankAccountDAOImp();
		ac.addAll(obj.getAccount(username));
		
		PreparedStatement pstmt = null;
		
		for (Account account : ac) {
			double ID = account.getAccountID();
			try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

				// use a prepared statement
				String sql = "DELETE FROM BANK_TRANSACTIONS WHERE ACCOUNT_ID = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setDouble(1, ID);
				
				if (pstmt.executeUpdate() > 0) {
					System.out.println("Record of "+username+" has been successfully removed");
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return false;
		
	}
	
	
}
