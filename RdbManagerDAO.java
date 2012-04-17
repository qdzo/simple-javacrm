package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.RowSet;

public class RdbManagerDAO implements ManagerDAO{

	private final static String TABLE_NAME = "person";
	private final static String PERS_ID = "pers_id";
	private final static String FIRST_NAME = "first_name";
	private final static String SECOND_NAME = "second_name";
	private final static String TELEPHONE = "tel";
	private final static String EMAIL = "email";
	private final static String GROUP_ID = "group_id";
	private final static String STATUS_ID = "status_id";
	public static final int SELECT = 1;
	public static final int INSERT = 2;
	public static final int UPDATE = 3;
	public static final int DELETE = 4;
	
	@Override
	public int insertManager(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean deleteManager(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Manager findManager(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateManager(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public RowSet selectManagersRS(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<Manager> selectManagersTO(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static Client buildManager(ResultSet rs){
		Client client;
		try {
			client = new Client(rs.getInt(PERS_ID));
			client.setFirstName(rs.getString(FIRST_NAME));
			client.setSecondName(rs.getString(SECOND_NAME));
			Integer tel = rs.getInt(TELEPHONE);
			client.setTelephone(tel.toString());
			client.setEmail(rs.getString(EMAIL));		
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	private static Collection<Manager> buildManagers(ResultSet rs){
		Collection<Manager> clientsCollection = new ArrayList<Manager>();
		try {
			while(rs.next()){
			Manager manager = new Manager(rs.getInt(PERS_ID));
			manager.setFirstName(rs.getString(FIRST_NAME));
			manager.setSecondName(rs.getString(SECOND_NAME));
			Long tel = rs.getLong(TELEPHONE);
			manager.setTelephone(tel.toString());
			manager.setEmail(rs.getString(EMAIL));
			int stat = rs.getInt(STATUS_ID);
			switch (stat){
			case 1:
				manager.setStatus(Status.Актуально);
				break;
			case 2:
				manager.setStatus(Status.Недействительно);
			}
			manager.setModelStatus(ModelStatus.Exist);
			clientsCollection.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsCollection;
	}

	
	public static String buildQuery(Manager manager,int queryType){
		
		Integer id = manager.getId();
		List<String> columns = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		if(manager.getFirstName()!=null){
			columns.add(FIRST_NAME);
			values.add(manager.getFirstName());
		}
		if(manager.getSecondName()!=null){
			columns.add(SECOND_NAME);
			values.add(manager.getSecondName());
		}
		if(manager.getTelephone()!=null){
			columns.add(TELEPHONE);
			values.add(manager.getTelephone());
		}
		if(manager.getEmail()!=null){
			columns.add(EMAIL);
			values.add(manager.getEmail());
		}
		if(manager.getStatus()!=null){
			columns.add(STATUS_ID);
			Integer statusId = manager.getStatus().getValue();
			values.add(statusId.toString());
		}
		
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
			return RdbDAOFactory.sql.buildDelete(TABLE_NAME, PERS_ID, id, STATUS_ID);
		}
		
		return null;
	}

}
