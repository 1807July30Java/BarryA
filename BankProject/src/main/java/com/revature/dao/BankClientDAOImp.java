package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.revature.pojo.*;
import com.revature.util.ConnectionUtil;


public class BankClientDAOImp implements BankClientDAO{
	private String filename = "connectionProperties";
	

	
	// Creating the client account and information.

	public boolean addClient(Client client) {
		
		if (client == null) {
			System.out.println(("null cave entered"));
			return false;
		}
			
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "INSERT INTO BANK_CLIENT (FIRST_NAME, LAST_NAME, USER_NAME, PASSWORD) VALUES (?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, client.getFirstName());
			pstmt.setString(2, client.getLastName());
			pstmt.setString(3, client.getUserName());
			pstmt.setString(4, client.getPassword());
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Welcome "+client.getFirstName() +" "+ client.getLastName());
				System.out.println("your username is: "+ client.getUserName());
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
		
		
	}
	
	//Changing First Name and Last Name

	public boolean updateClient(Client client) {
		
		
		return false;
		
	}

	
	
	//Deleting User Account Records
	public boolean deleteClient(String username) {
		
		if (username == null) {
			System.out.println(("Enter a Valid username and try again"));
			return false;
		}
			
		PreparedStatement pstmt = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {

			// use a prepared statement
			String sql = "DELETE FROM BANK_CLIENT WHERE USER_NAME = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			
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

	//Getting client Info by username
	
	public Client getClientInfo(String username) {
		
		
		PreparedStatement pstmt = null;
		Client client = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			String sql = "SELECT * FROM BANK_CLIENT WHERE USER_NAME= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()){
				double userID = rs.getInt("CLIENT_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String password = rs.getString("PASSWORD");
				
				
				client = new Client(userID, firstName, lastName, password,username);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		;
		return client;
	
	}

	
public Client getClientInfoAuth(String username,String pass) {
		PreparedStatement pstmt = null;
		Client client = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile(filename)){

			String sql = "SELECT * FROM BANK_CLIENT WHERE USER_NAME= ? AND PASSWORD=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()){
				double userID = rs.getInt("CLIENT_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String password = rs.getString("PASSWORD");
				
				
				client = new Client(userID, firstName, lastName, password,username);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		;
		return client;
	
	}

	
	

	
}
