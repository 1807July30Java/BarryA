package com.revature.dao;
import com.revature.pojo.*;

public interface BankDAO {
	Account addAccount(Account account);
	Client addClient(Client client);
	
	Boolean removeAccount();
	Boolean removeUser();

}
