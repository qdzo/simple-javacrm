package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.RowSet;

public class RdbDestributionDAO  implements DestributionDAO{

	private final static String PERSON_TABLE = "person";
	private final static String PRODUCT_TABLE = "product";
	private final static String DESTRIBUTION_TABLE = "destribution";
	private final static String DEST_ID = "dest_id";
	private final static String DATE = "date";
	private final static String PRODUCT_ID = "product_id";
	private final static String MANAGER_ID = "mngr_id";
	private final static String CLIENT_ID = "clnt_id";
	private final static String DESTRIB_COMMENT ="destrib_comment";
	private final static String DEST_STATUS_ID = "dest_status_id";
	private final static String PERSON_CLIENT_ID = "pers_id";
	private final static String PERSON_FIRST_NAME =	"firstName";
	private final static String PERSON_LAST_NAME = "secondName";
	private final static String PRODUCT_PROD_ID = "prod_id";
	private final static String PRODUCT_PROD_NAME ="prod_name";
	public static final int SELECT = 1;
	public static final int INSERT = 2;
	public static final int UPDATE = 3;
	public static final int DELETE = 4;
	private static String[] selectedColumns;
	private static String[] tableNames;
	private static String[] equivalentColumns;

	public int insertDestribution(Destribution destribution) {
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
		return 0;
	}

	@Override
	public boolean deleteDestribution(Destribution destribution) {
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
		return false;
	}


	public Destribution findDestribution(Destribution destribution) {
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(destribution,SELECT);
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


	public boolean updateDestribution(Destribution destribution) {
		int flag = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(destribution,UPDATE);
			flag = statement.executeUpdate(query);
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
		if(flag==0)
		return false;
		else return true;
	}

	@Override
	public RowSet selectDestributionsRS(Destribution destribution) {
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
	public Collection<Destribution> selectDestributionsTO(Destribution destribution) {
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

//	private static Manager buildDestribution(ResultSet rs){
//		Destribution destribution;
//		try {
//			destribution = new Destribution(rs.getInt(DEST_ID));
//			destribution;
//			destribution.setSecondName(rs.getString(SECOND_NAME));
//			Integer tel = rs.getInt(TELEPHONE);
//			destribution.setTelephone(tel.toString());
//			destribution.setEmail(rs.getString(EMAIL));		
//			int stat = rs.getInt(STATUS_ID);
//			switch (stat){
//			case 1:
//				destribution.setStatus(Status.Актуально);
//				break;
//			case 2:
//				destribution.setStatus(Status.Недействительно);
//			}
//			destribution.setModelStatus(ModelStatus.Exist);
//			return destribution;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	
//	
//	private static Collection<Manager> buildManagers(ResultSet rs){
//		Collection<Manager> clientsCollection = new ArrayList<Manager>();
//		try {
//			while(rs.next()){
//			Manager manager = new Manager(rs.getInt(PERS_ID));
//			manager.setFirstName(rs.getString(FIRST_NAME));
//			manager.setSecondName(rs.getString(SECOND_NAME));
//			Long tel = rs.getLong(TELEPHONE);
//			manager.setTelephone(tel.toString());
//			manager.setEmail(rs.getString(EMAIL));
//			int stat = rs.getInt(STATUS_ID);
//			switch (stat){
//			case 1:
//				manager.setStatus(Status.Актуально);
//				break;
//			case 2:
//				manager.setStatus(Status.Недействительно);
//			}
//			manager.setModelStatus(ModelStatus.Exist);
//			clientsCollection.add(manager);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return clientsCollection;
//	}

	
	public static String buildQuery(Destribution destribution,int queryType){
		
		Integer id = destribution.getDestributionId();
		List<String> columns = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		if(destribution.getProductId()!=null){
			columns.add(PRODUCT_ID);
			values.add((destribution.getProductId()).toString());
		}
		if(destribution.getManagerId()!=null){
			columns.add(MANAGER_ID);
			values.add((destribution.getManagerId()).toString());
		}
		if(destribution.getClientId()!=null){
			columns.add(CLIENT_ID);
			values.add((destribution.getClientId()).toString());
		}
		if(destribution.getComment()!=null){
			columns.add(DESTRIB_COMMENT);
			values.add(destribution.getComment());
		}
		if(destribution.getStatus()!=null){
			columns.add(DEST_STATUS_ID);
			Integer statusId = destribution.getStatus().getValue();
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
			return RdbDAOFactory.sql.buildInsert(DESTRIBUTION_TABLE,col,val);
		case SELECT:
			return RdbDAOFactory.sql.buildSmartSelect(selectedColumns, tableNames, equivalentColumns, col, val);
		case UPDATE:
			return RdbDAOFactory.sql.buildUpdate(DESTRIBUTION_TABLE,col,val, DEST_ID, id);
		case DELETE:
			return RdbDAOFactory.sql.buildInvalidDelete(DESTRIBUTION_TABLE, DEST_ID, id, DEST_STATUS_ID);
		}
		
		return null;
	}
	
	private static void makeArrays(){
		
	}
	
}
