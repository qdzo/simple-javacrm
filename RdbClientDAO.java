package model;

import java.util.Collection;

import javax.sql.RowSet;

public class RdbClientDAO implements ClientDAO {
	
//==================================================================================================	
	
	public int insertClient(Client client){
	
		return 0;
	}

	@Override
	public boolean deleteClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client findClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RowSet selectClientsRS(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Client> selectClientsTO(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
