package model;

import java.util.Collection;

import javax.sql.RowSet;

public interface ClientDAO {
	
	public int insertClient();
	public boolean deleteClient();
	public Client findClient();
	public boolean updateClient();
	public RowSet selectClientsRS();
	public Collection<Client> selectClientsTO();

}
