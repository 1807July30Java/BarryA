package com.revature.logic;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.revature.dao.BankAccountDAOImp;
import com.revature.dao.BankClientDAOImp;
import com.revature.dao.BankTransactionsDAOImp;
import com.revature.pojo.*;

public class ScannerClass {
	
	public static void bankUI() {
		//Objection Creation
		
		BankClientDAOImp bClient = new BankClientDAOImp();
		BankAccountDAOImp bAccount = new BankAccountDAOImp();
		BankTransactionsDAOImp bTrans = new BankTransactionsDAOImp();
		
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
			System.out.println("");
			if (bClient.getClientInfoAuth(uname, pass)==null) {
				System.out.println("Please Try gain");
				break;
			}
			System.out.println("Please wait while we fetch your information...");
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
				System.out.println("Please enter you username to confirm");
				String unserame = sc.nextLine();
					System.out.println("please enter your password:");
				String passw = sc.nextLine();
					if (bClient.getClientInfoAuth(unserame, passw)==null) {
						System.out.println("Please Try gain");
						break;
					}
					System.out.println("Bye Bye");
					
				bTrans.deleteTransactiontByUser(uname);
				bAccount.deleteAccountByUser(uname);
				bClient.deleteClient(uname);
					
			}else if (fol.equalsIgnoreCase("A")) {
				System.out.println("We will walk you through creating an account");
				System.out.println("Would you like a checking or savings account?");
				String accountName = sc.nextLine();
				System.out.println("Please enter an initial Balance for your "+accountName+" account");
				double currentBalance = sc.nextDouble();
				System.out.println("Please be patient while we create your account");
				Account account = new Account(accountName, currentBalance);
				System.out.println(bAccount.addAccount(account, uname));

				System.out.println("Perform other Transactions?: Yes/No");
				String c = sc.nextLine();
				if (c.equalsIgnoreCase("yes")) {
					condition = true;
				}
				
			}else if (fol.equalsIgnoreCase("D")) {
				System.out.println("Enter the account number of the account you wish to delete.");
				double accountID = sc.nextDouble();
				System.out.println("Please wait while we delete you account..");
				bAccount.deleteAccountByID(accountID);
				
				System.out.println("Perform other Transactions?: Yes/No");
				String c = sc.nextLine();
				if (c.equalsIgnoreCase("yes")) {
					condition = true;
				}
			}else if (fol.equalsIgnoreCase("C")) {
				System.out.println("We will walk you through changing your information");
				
				
				System.out.println("Perform other Transactions?: Yes/No");
				String c = sc.nextLine();
				if (c.equalsIgnoreCase("yes")) {
					condition = true;
				}
				
			}else if (fol.equalsIgnoreCase("R")) {
				System.out.println("Here are all the accounts under "+ uname);
				System.out.println(bAccount.getAccount(uname));
				
				System.out.println("Perform other Transactions?: Yes/No");
				String c = sc.nextLine();
				if (c.equalsIgnoreCase("yes")) {
					condition = true;
				}
			}else if (fol.equalsIgnoreCase("P")) {
				System.out.println("Would you like to deposit or extract money?");
				String depoEx = sc.nextLine();
				if (depoEx.equalsIgnoreCase("deposit")) {
					System.out.println("Enter the account ID in which you like to perform this transaction");
					double accountID = sc.nextDouble();
					System.out.println("How much would you like to deposit?");
					double balance = sc.nextDouble();
					Transactions trans = new Transactions("Deposit");
					bTrans.addIncrementingTrans(trans, balance, accountID, uname);
					
					System.out.println("Perform other Transactions?: Yes/No");
					String c = sc.nextLine();
					if (c.equalsIgnoreCase("yes")) {
						condition = true;
					}
					
				}else {
					System.out.println("Enter how much this transaction will cost (Warning, you must have enough funds to perform transaction)");
					double balance = sc.nextDouble();
					System.out.println("Enter the account ID in which you like to perform this transaction");
					double accountID = sc.nextDouble();
					System.out.println("Enter the nature of the transaction");
					String transactionDetails = sc.next();
					System.out.println("Please wait while we safely perform");
					Transactions tr = new Transactions(transactionDetails);
					bTrans.addDecrementingTrans(tr, balance, accountID, uname);
					System.out.println("Perform other Transactions?: Yes/No");
					String c = sc.nextLine();
					if (c.equalsIgnoreCase("yes")) {
						condition = true;
					}
				}

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
