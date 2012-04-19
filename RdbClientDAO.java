package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.RowSet;

public class RdbClientDAO implements ClientDAO {
	
	
	private final static String TABLE_NAME = "person";
	public final static int SELECT = 1;
	public final static int INSERT = 2;
	public final static int UPDATE = 3;
	public final static int DELETE = 4;
	private final static String PERS_ID = "pers_id";
	private final static String FIRST_NAME = "first_name";
	private final static String SECOND_NAME = "second_name";
	private final static String TELEPHONE = "tel";
	private final static String EMAIL = "email";
	private final static String PRIORITY_ID = "priority_id";
	private final static String STATUS_ID = "status_id";
	private final static String GROUP_ID = "group_id";
//==================================================================================================	
	
	public int insertClient(Client client){
	
		int result = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(client,RdbClientDAO.INSERT);
			System.out.println(query);
			result = statement.executeUpdate(query);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (InstantiationException e) {
					e.printStackTrace();
		} catch (IllegalAccessException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public boolean deleteClient(Client client) {
		
		int result=0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(client,RdbClientDAO.DELETE);
			result = statement.executeUpdate(query);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
			} catch (InstantiationException e) {
					e.printStackTrace();
			} catch (IllegalAccessException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		if(result==1)
			return true;
		else
		return false;
	}


	public Client findClient(Client client) {
		
		Client findedClient = null;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(client,RdbClientDAO.SELECT);
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
			findedClient = buildClient(resultSet);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		
			return findedClient;
		}

	@Override
	public boolean updateClient(Client client) {
		
		int result = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(client,RdbClientDAO.UPDATE);
			System.out.println(query);
			result = statement.executeUpdate(query);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (InstantiationException e) {
					e.printStackTrace();
		} catch (IllegalAccessException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		if(result==1)
			return true;
		else
		return false;
	}


	public RowSet selectClientsRS(Client client) {

		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(client, SELECT);
			ResultSet resultSet = statement.executeQuery(query);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	

	@Override
	public Collection<Client> selectClientsTO(Client client) {

		Collection<Client> clients = new ArrayList<Client>();
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(client,SELECT);
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
			clients = buildClients(resultSet);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clients;
	}

	private static Client buildClient(ResultSet rs){
		Client client;
		try {
			if(rs.next()){
			client = new Client(rs.getInt(PERS_ID));
			client.setFirstName(rs.getString(FIRST_NAME));
			client.setSecondName(rs.getString(SECOND_NAME));
			Long tel = rs.getLong(TELEPHONE);
			client.setTelephone(tel.toString());
			client.setEmail(rs.getString(EMAIL));
			
			if(Priority.Низкий.getValue()==rs.getInt(PRIORITY_ID)){
			client.setPriority(Priority.Низкий);
			} else if(Priority.Средний.getValue()==rs.getInt(PRIORITY_ID)){
				client.setPriority(Priority.Средний);
			} else if(Priority.Высокий.priorityValue==rs.getInt(PRIORITY_ID)){
				client.setPriority(Priority.Высокий);
			}
			
			
			int stat = rs.getInt(STATUS_ID);
			switch (stat){
			case 1:
				client.setStatus(Status.Актуально);
				break;
			case 2:
				client.setStatus(Status.Недействительно);
			}
			client.setModelStatus(ModelStatus.Exist);
			return client;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static Collection<Client> buildClients(ResultSet rs){
		Collection<Client> clientsCollection = new ArrayList<Client>();
		try {
			while(rs.next()){
			Client client = new Client(rs.getInt(PERS_ID));
			client.setFirstName(rs.getString(FIRST_NAME));
			client.setSecondName(rs.getString(SECOND_NAME));
			Long tel = rs.getLong(TELEPHONE);
			client.setTelephone(tel.toString());
			client.setEmail(rs.getString(EMAIL));
			switch (rs.getInt(PRIORITY_ID)){
			case 1:
				client.setPriority(Priority.Высокий);
				break;
			case 2:
				client.setPriority(Priority.Средний);
				break;
			case 3:
				client.setPriority(Priority.Низкий);
				break;
			default: 
				client.setPriority(Priority.Средний);
			}
			int stat = rs.getInt(STATUS_ID);
			switch (stat){
			case 1:
				client.setStatus(Status.Актуально);
				break;
			case 2:
				client.setStatus(Status.Недействительно);
			}
			client.setModelStatus(ModelStatus.Exist);
			clientsCollection.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsCollection;
	}

	
	
	public static String buildQuery(Client client,int queryType){
		
		Integer id = client.getId();
		List<String> columns = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		if(client.getFirstName()!=null){
			columns.add(FIRST_NAME);
			values.add(client.getFirstName());
		}
		if(client.getSecondName()!=null){
			columns.add(SECOND_NAME);
			values.add(client.getSecondName());
		}
		if(client.getTelephone()!=null){
			columns.add(TELEPHONE);
			values.add(client.getTelephone());
		}
		if(client.getEmail()!=null){
			columns.add(EMAIL);
			values.add(client.getEmail());
		}
		if(client.getPriority()!=null){
			columns.add(PRIORITY_ID);
			Integer prio_id = client.getPriority().getValue();
			values.add(prio_id.toString());
		}
		if(client.getStatus()!=null){
			columns.add(STATUS_ID);
			Integer statusId = client.getStatus().getValue();
			values.add(statusId.toString());
		}
		columns.add(GROUP_ID);
		values.add("2");
		String[] col =  new String[columns.size()];
		String [] val = new String[values.size()];
		for(int i=0;i<columns.size();i++){
			col[i]=columns.get(i);
			val[i]=values.get(i);
		}
		switch(queryType){
		case INSERT:
			return RdbDAOFactory.sql.buildInsert(TABLE_NAME,col,val);
		case SELECT:
			return RdbDAOFactory.sql.buildSelect(TABLE_NAME,col,val);
		case UPDATE:
			return RdbDAOFactory.sql.buildUpdate(TABLE_NAME,col,val, PERS_ID, id);
		case DELETE:
			return RdbDAOFactory.sql.buildInvalidDelete(TABLE_NAME, PERS_ID, id, STATUS_ID);
		}
		
		return null;
	}
	
}
