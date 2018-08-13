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

import com.revature.pojo.Account;
import com.revature.pojo.Client;
import com.revature.util.ConnectionUtil;

public class BankAccountDAOImp implements BankAccountDAO {
	private String filename = "connectionProperties";
	
	//Retrieving account
	public List<Account> getAccount(String username) {
		BankClientDAOImp obj1 = new BankClientDAOImp();
		if (obj1.getClientInfo(username)==null) {
			return null;
		}
		
		
		List <Account> account = new ArrayList<>();
		if (username == null) {
			System.out.println("Enter a valid username");
		}
		BankClientDAOImp obj = new BankClientDAOImp();
		double ID = obj.getClientInfo(username).getUserID();
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, ID);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				double accountID = rs.getDouble("ACCOUNT_ID");
				String accountName = rs.getString("ACCOUNT_NAME");
				double currentBalance = rs.getDouble("BALANCE");
				String creationDate = rs.getString("DATE_CREATED");
				
				account.add(new Account(accountName, currentBalance, accountID, creationDate));
			}
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return account;
	}
	/***********************************************************************************************************************************************/

	//Deleting an Account 
	
	public boolean deleteAccountByID(double accountID) {
		BankClientDAOImp obj = new BankClientDAOImp();
		
		
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "DELETE FROM BANK_ACCOUNT WHERE ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, accountID);
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Record of account "+accountID+" has been successfully removed");
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

	//Adding an account
	
	@Override
	public boolean addAccount(Account account, String username) {
		
		
		BankClientDAOImp obj = new BankClientDAOImp();
		double ID = obj.getClientInfo(username).getUserID();
		
		
		if (account == null) {
			System.out.println(("null account entered"));
			return false;
		}
			
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "INSERT INTO BANK_ACCOUNT (ACCOUNT_NAME, BALANCE, DATE_CREATED, USER_ID) VALUES (?, ?, ?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, account.getAccountName());
			pstmt.setDouble(2, account.getCurrentBalance());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pstmt.setString(3,formatter.format( account.getCreationDate()));
			pstmt.setDouble(4, ID);
	
			if (pstmt.executeUpdate() > 0) {
				System.out.println(account.getAccountName() +" Successfully created");
				System.out.println("Account Balance = $ "+account.getCurrentBalance());
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

	//deleting all existing records for an account

	@Override
	public boolean deleteAccountByUser(String username) {
		if (username == null) {
			System.out.println(("Enter a Valid username and try again"));
			return false;
		}
			
		BankClientDAOImp obj = new BankClientDAOImp();
		double ID = obj.getClientInfo(username).getUserID();
		
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "DELETE FROM BANK_ACCOUNT WHERE USER_ID = ?";
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

		return false;
		
	}
	/***********************************************************************************************************************************************/

	@Override
	public boolean updateAccountBalance(double accountID, double balance) {
		
		PreparedStatement pstmt = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "UPDATE BANK_ACCOUNT SET BALANCE = ? WHERE ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, balance);
			pstmt.setDouble(2, accountID);
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Your account balance is now = $"+balance);
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

	//Getting account information from the ID
	
	@Override
	public Account getAccountByAccountID(double ID, String username) {
		BankAccountDAOImp obj = new BankAccountDAOImp();
		List<Account> ac = new ArrayList<>();
		ac.addAll(obj.getAccount(username));
	
		
		PreparedStatement pstmt = null;
		Account account = null;
		
		for (Account a : ac) {
			if (a.getAccountID()!= ID) {
				System.out.println("Incorrect account ID");
				System.out.println("Please try again");
				return null;
			}
		}
		
		
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			String sql = "SELECT * FROM BANK_ACCOUNT WHERE ACCOUNT_ID= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, ID);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()){
				double accountID = rs.getInt("ACCOUNT_ID");
				String accountName = rs.getString("ACCOUNT_NAME");
				double currentBalance = rs.getDouble("BALANCE");
				String creationDate = rs.getString("DATE_CREATED");
				
				account = new Account(accountName, currentBalance, accountID, creationDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		;
		return account;
	}

}
