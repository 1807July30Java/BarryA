package com.revature.dao;
import java.util.List;
import com.revature.pojo.Account;

public interface BankAccountDAO {
	public List<Account> getAccount (String name);
	public boolean deleteAccount (Account account);

}
