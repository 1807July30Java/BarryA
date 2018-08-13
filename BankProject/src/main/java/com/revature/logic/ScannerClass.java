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
		
		try {
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
			String uname = sc.next();
				System.out.println("please enter your password:");
			String pass = sc.next();
				System.out.println("");
				System.out.println("Please wait while we fetch your information...");
				if (bClient.getClientInfoAuth(uname, pass)==null) {
					System.out.println("Please Try gain");
					break;
				}
				boolean menu = true;
				do {
				System.out.println(bClient.getClientInfoAuth(uname, pass));
				System.out.println("");
				System.out.println(bAccount.getAccount(uname));
				System.out.println("");
				System.out.println("For adding an account, press 'A'");
				System.out.println("For deleting an account, press 'D'");
				System.out.println("To see transaction history press 'H'");
				System.out.println("For Retrieving existing account(s), press 'R'");
				System.out.println("For performing a transaction, press 'P'");
				System.out.println("If you no longer wish to be part of our community, press 'X'");
				System.out.println("If you wish to log Out press 'L'");
				
				String fol = sc.next();
				if (fol.equalsIgnoreCase("L")) {	
					System.out.println("You have successfully signed out");
					condition = false;
					break;	
				}
				
				if (fol.equalsIgnoreCase("X")) {
					System.out.println("We are sorry to see you leave ...");
					System.out.println("Please enter you username to confirm");
					String unserame = sc.next();
						System.out.println("please enter your password:");
					String passw = sc.next();
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
					String accountName = sc.next();
					System.out.println("Please enter an initial Balance for your "+accountName+" account");
					double currentBalance = sc.nextDouble();
					if (currentBalance<0) {
						System.out.println("Strating balance can't be negatif");
						break;
					}
					
					System.out.println("Please be patient while we create your account");
					Account account = new Account(accountName, currentBalance);
					System.out.println(bAccount.addAccount(account, uname));

					System.out.println("Perform other Transactions?: Yes/No");
					String c = sc.nextLine();
					if (c.equalsIgnoreCase("yes")) {
						condition = true;
					}
					
				}else if (fol.equalsIgnoreCase("D")) {
					System.out.println("Only empty accounts can be deleted!!");
					System.out.println("Enter the account number of the account you wish to delete.");
					double accountID = sc.nextDouble();
					System.out.println("Please wait while we delete you account..");
					if (bAccount.getAccountByAccountID(accountID, uname).getCurrentBalance()==0) {
						bTrans.deleteTransactiontByUser(uname);
						bAccount.deleteAccountByID(accountID);
					}else {
						System.out.println("Transaction Falied!");
						System.out.println("Please verify that your funds= 0");
					}
					
					System.out.println("Perform other Transactions?: Yes/No");
					String c = sc.next();
					if (c.equalsIgnoreCase("yes")) {
						condition = true;
					}
				}else if (fol.equalsIgnoreCase("h")) {
					System.out.println("Have your account ID ready..");
					System.out.println("Enter your account ID");
					double accountID = sc.nextDouble();
					System.out.println("Retrieving info ...");
					bTrans.getAllTransactions(accountID, uname);
					
					System.out.println("Perform other Transactions?: Yes/No");
					String c = sc.next();
					if (c.equalsIgnoreCase("yes")) {
						condition = true;
					}
					
				}else if (fol.equalsIgnoreCase("R")) {
					System.out.println("Here are all the accounts under "+ uname);
					System.out.println(bAccount.getAccount(uname));
					
					System.out.println("Perform other Transactions?: Yes/No");
					String c = sc.next();
					if (c.equalsIgnoreCase("yes")) {
						condition = true;
					}
				}else if (fol.equalsIgnoreCase("P")) {
					boolean rep= false;
					do {
						System.out.println("Would you like to deposit or extract money?");
						String depoEx = sc.next();
						if (depoEx.equalsIgnoreCase("deposit")) {
							System.out.println("Enter the account ID in which you like to perform this transaction");
							double accountID = sc.nextDouble();
							System.out.println("How much would you like to deposit?");
							double balance = sc.nextDouble();
							System.out.println("Please wait while we safely perform...");
							Transactions trans = new Transactions("Deposit");
							bTrans.addIncrementingTrans(trans, balance, accountID, uname);
							System.out.println("Perform other Transactions?: Yes/No");
							String c = sc.next();
							if (c.equalsIgnoreCase("yes")) {
								rep = true;
							}else {rep =false;
							condition= true;
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
							String c = sc.next();
							if (c.equalsIgnoreCase("yes")) {
								rep = true;
							}else {
								rep =false;
								condition= true;
							}
						}
						
					} while (rep);


				}
			
				}while (menu);}
			else if(us.equalsIgnoreCase("new")) {
				
				System.out.println("We will help you add your account ...");
				System.out.println("Please enter your first name");
				String firstName = sc.next();
				System.out.println("Please enter your last name");
				String lastName = sc.next();
				System.out.println("Please create a username");
				String userName = sc.next();
				System.out.println("Please create a password");
				String password = sc.next();
				System.out.println("We are creating your personal login information please be patient...");
				Client client = new Client(firstName, lastName, userName, password);
				bClient.addClient(client);
				System.out.println("Go to your account: Yes/No");
				String c = sc.next();
				
				if (c.equalsIgnoreCase("yes")) {
					condition = true;
				}
			}
			}while (condition);
		} catch (Exception e) {
			System.out.println("Not valid entry. Please try again");
		}
	}
	
	
}
