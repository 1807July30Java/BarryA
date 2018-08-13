package com.revature.dao;
import java.util.List;
import com.revature.pojo.Account;

public interface BankAccountDAO {
	public List<Account> getAccount (String username);
	public boolean deleteAccountByID (double accountID);
	public boolean deleteAccountByUser(String username);
	public boolean addAccount (Account account, String username);
	public boolean updateAccountBalance (double accountID, double balance);
	public Account getAccountByAccountID (double ID, String username);

}
