package com.revature.logic;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.revature.dao.BankAccountDAOImp;
import com.revature.dao.BankClientDAOImp;
import com.revature.pojo.*;

public class ScannerClass {
	
	public static void bankUI() {
		//Objection Creation
		
		BankClientDAOImp bClient = new BankClientDAOImp();
		BankAccountDAOImp bAccount = new BankAccountDAOImp();
		
		//Objection Creation End
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to our Bank User Interface");
		System.out.println("");
		boolean condition = false;
		do {	
		System.out.println("Please enter <New or Returning> user");
		String us = sc.nextLine();
		
		//If returning User, we will ask for the username and display the information in the DB
		if (us.equalsIgnoreCase("Returning")) {
			System.out.println("Please enter you username:");
		String uname = sc.nextLine();
			System.out.println("please enter your password:");
		String pass = sc.nextLine();
			System.out.println("Welcome to your account:");
			System.out.println("");
			System.out.println(bClient.getClientInfoAuth(uname, pass));
			System.out.println("");
			System.out.println(bAccount.getAccount(uname));
			System.out.println(" ");
			System.out.println("For adding an account, press 'A'");
			System.out.println("For deleting an account, press 'D'");
			System.out.println("For Changing user information such name, username, password etc, press 'C'");
			System.out.println("For Retrieving existing account(s), press 'R'");
			System.out.println("For performing a transaction, press 'P'");
			System.out.println("If you no longer wish to be part of our community, press 'X'");
			String fol = sc.nextLine();
			if (fol.equalsIgnoreCase("X")) {
				System.out.println("We are sorry to see you leave ...");
				bAccount.deleteAccountByUser(uname);
				bClient.deleteClient(uname);
				System.out.println("Bye Bye");	
			}else if (fol.equalsIgnoreCase("A")) {
				System.out.println("We will walk you through creating an account");
				System.out.println("Would you like a checking or savings account?");
				String accountName = sc.nextLine();
				System.out.println("Please enter an initial Balance for your "+accountName+" account");
				double currentBalance = sc.nextDouble();
				System.out.println("Please be patient while we create your account");
				Account account = new Account(accountName, currentBalance);
				System.out.println(bAccount.addAccount(account, uname));
				break;
			}
		
		}else {
			System.out.println("We will help you add your account ...");
			System.out.println("Please enter your first name");
			String firstName = sc.nextLine();
			System.out.println("Please enter your last name");
			String lastName = sc.nextLine();
			System.out.println("Please create a username");
			String userName = sc.nextLine();
			System.out.println("Please create a password");
			String password = sc.nextLine();
			System.out.println("We are creating your personal login information please be patient...");
			Client client = new Client(firstName, lastName, userName, password);
			bClient.addClient(client);
			System.out.println("Go to your account: Yes/No");
			String c = sc.nextLine();
			
			if (c.equalsIgnoreCase("yes")) {
				condition = true;
			}
		}
		}while (condition);
	}
	
	
	
	

}
