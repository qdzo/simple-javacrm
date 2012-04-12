package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.RowSet;

public class RdbClientDAO implements ClientDAO {
	
	private final static int SELECT = 1;
	private final static int INSERT = 2;
	private final static int UPDATE = 3;
	private final static int DELETE = 4;
	private final static String QUOTES = "\'";
	private final static String QUOTES_WITH_COMMA = "\',\'";
	private final static String COMMA = ",";
	private final static String PERS_ID = "pers_id";
	private final static String FIRST_NAME = "first_name";
	private final static String SECOND_NAME = "second_name";
	private final static String TELEPHONE = "tel";
	private final static String EMAIL = "email";
	private final static String GROUP_ID = "group_id";
	private final static String PRIORITY_ID = "priority_id";
	private final static String STATUS_ID = "status_id";
	
//==================================================================================================	
	
	public int insertClient(Client client){
	
		int result = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			System.out.println("connection is created!");
			Statement statement = connection.createStatement();
			System.out.println("statement is created!");
			String sql=null;
			System.out.println(sql);
			result = statement.executeUpdate(sql);
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
			
			
			result = statement.executeUpdate(null);
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

	@Override
	public Client findClient(Client client) {
				try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
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
	public boolean updateClient(Client client) {
		
		int result = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			result = statement.executeUpdate("select");
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

	@Override
	public RowSet selectClientsRS(Client client) {

		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query;
			ResultSet resultSet = statement.executeQuery(null);
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
//			String query = "select p.pers_id,p.first_name,p.second_name,p.tel,p.email,pb.belong,pr.name," +
//					"st.status_name from person p left outer join person_belong pb on p.belong = pb.id left outer join " +
//					"priority pr on p.priority = pr.prio_id left outer join status st on p.status = st.stat_id where pb.belong ='клиент';";
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
			client = new Client(rs.getInt(PERS_ID));
			client.setFirstName(rs.getString(FIRST_NAME));
			client.setSecondName(rs.getString(SECOND_NAME));
			Integer tel = rs.getInt(TELEPHONE);
			client.setTelephone(tel.toString());
			client.setEmail(rs.getString(EMAIL));
			
			if(Priority.low.getValue()==rs.getInt(PRIORITY_ID)){
			client.setPriority(Priority.low);
			} else if(Priority.Medium.getValue()==rs.getInt(PRIORITY_ID)){
				client.setPriority(Priority.Medium);
			} else if(Priority.Hi.priorityValue==rs.getInt(PRIORITY_ID)){
				client.setPriority(Priority.Hi);
			}
			
			
			int stat = rs.getInt(STATUS_ID);
			switch (stat){
			case 1:
				client.setStatus(Status.актуально);
				break;
			case 2:
				client.setStatus(Status.недействительно);
			}
			client.setModelStatus(ModelStatus.Exist);
			return client;
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
				client.setPriority(Priority.Hi);
				break;
			case 2:
				client.setPriority(Priority.Medium);
				break;
			case 3:
				client.setPriority(Priority.low);
				break;
			default: 
				client.setPriority(Priority.Medium);
			}
			int stat = rs.getInt(STATUS_ID);
			switch (stat){
			case 1:
				client.setStatus(Status.актуально);
				break;
			case 2:
				client.setStatus(Status.недействительно);
			}
			client.setModelStatus(ModelStatus.Exist);
			clientsCollection.add(client);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientsCollection;
	}

	
	
	private static String buildQuery(Client client,int queryType){
		
		String columns = null;
		String values = null;
		Integer id = client.getId();
		if(client.getFirstName()!=null){
			columns = FIRST_NAME;
			values = client.getFirstName();
		}
		if(client.getSecondName()!=null){
			if(columns!=null){
				columns += COMMA;
				values += COMMA;
			}
			columns += SECOND_NAME;
			values += client.getSecondName();
		}
		if(client.getTelephone()!=null){
			if(columns!=null){
				columns += COMMA;
				values += COMMA;
			}
			columns += TELEPHONE;
			values += client.getTelephone();
		}
		if(client.getEmail()!=null){
			if(columns!=null){
				columns += COMMA;
				values += COMMA;
			}
			columns += COMMA;
			values += COMMA;
		}	
		if(client.getPriority()!=null){
			if(columns!=null){
				columns += COMMA;
				values += COMMA;
			}
			columns += PRIORITY_ID;
			values += client.getPriority().getValue();
		}
		if(client.getStatus()!=null){
			if(columns!=null){
				columns += COMMA;
				values += COMMA;
			}
			columns += STATUS_ID;
			values += client.getStatus().getValue();
		}
		switch (queryType){
		case SELECT:
			return buildSelect(columns,values);
		case INSERT:
			return buildInsert(columns,values);
		case UPDATE:
			return buildUpdate(columns,values,id);
		case DELETE:
			return buildDelete(columns,values,id);
		}
		return null;
	}
	
	
	private static String buildDelete(String columns, String values,int id) {
		String sql = "UPDATE person SET "+STATUS_ID+"=2 WRERE "+PERS_ID+"="+id+";";
		return sql;
	}

	
	private static String buildUpdate(String columns, String values,int id) {
		String sql = "UPDATE person SET ";
			while(columns.indexOf(COMMA)>0){
			 sql += columns.substring(0, columns.indexOf(COMMA))+"=\""+values.substring(0, values.indexOf(COMMA))+"\" AND ";
			 columns = columns.substring(columns.indexOf(COMMA)+1);
			 values = values.substring(values.indexOf(COMMA)+1);
		 }
		 sql += columns+"=\""+values+"\" ";
		 sql +="WHERE "+PERS_ID+"="+id+";";
		return null;
	}

	
	private static String buildInsert(String columns, String values) {
		values = values.replace(COMMA, QUOTES_WITH_COMMA);
		String sql = "INSERT INTO person("+columns+") VALUES (\'"+values+"\');";
		return sql;
	}

	
	private static String buildSelect(String columns,String values){
		String sql = "SELECT * FROM person WHERE "+GROUP_ID+"=2";
		if(columns!=null){
			while(columns.indexOf(COMMA)>0){
			 sql += " AND "+columns.substring(0, columns.indexOf(COMMA))+"="+values.substring(0, values.indexOf(COMMA));
			 columns = columns.substring(columns.indexOf(COMMA)+1);
			 values = values.substring(values.indexOf(COMMA)+1);
		 }
		 sql += " AND "+columns+"="+values;
		}
		sql += ";";
		return sql;
	}
	
}
