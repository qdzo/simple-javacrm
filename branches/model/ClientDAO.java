package model;

import java.util.Collection;

import javax.sql.RowSet;

public interface ClientDAO {
	
	public int insertClient(Client client);
	public boolean deleteClient(Client client);
	public Client findClient(Client client);
	public boolean updateClient(Client client);
	public RowSet selectClientsRS(Client client);
	public Collection<Client> selectClientsTO(Client client);

}
