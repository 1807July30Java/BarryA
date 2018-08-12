package com.revature.mainmethod;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.*;
import com.revature.pojo.*;
import com.revature.util.ConnectionUtil;


public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filename = "connectionProperties";
		
		try {
			Connection con = ConnectionUtil.getConnectionFromFile(filename);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Success");
		
		BankClientDAOImp obj = new BankClientDAOImp();
		Client one = new Client("Alpha", "Barry", "abarry", "revature");
//		obj.deleteClient("abarry");
		System.out.println(obj.getClientInfo("abarry"));
		
		BankAccountDAOImp obj1 = new BankAccountDAOImp();
//		Account ac = new Account("Checking Account", 100);
//		ac.setCurrentBalance(200);
//		obj1.addAccount(ac,"abarry");
		 
		System.out.println(obj1.getAccount("abarry"));

	}

}
