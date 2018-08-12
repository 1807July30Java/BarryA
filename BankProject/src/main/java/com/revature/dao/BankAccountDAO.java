package com.revature.dao;
import java.util.List;
import com.revature.pojo.Account;

public interface BankAccountDAO {
	public List<Account> getAccount (String username);
	public boolean deleteAccount (Account account);
	public boolean deleteAccountByUser(String username);
	public boolean addAccount (Account account, String username);

}
