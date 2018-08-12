package com.revature.dao;
import java.util.List;

import com.revature.pojo.*;

public interface BankClientDAO {
	
	public boolean addClient(Client client);
	public boolean updateClient(Client client);
	public boolean deleteClient(String username);
	public Client getClientInfo (String username);
	public Client getClientInfoAuth (String username, String password);

}
