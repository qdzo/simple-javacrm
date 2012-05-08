package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.RowSet;

public class RdbDestributionDAO  implements DestributionDAO{

	
	private final static String DESTRIBUTION_TABLE = "destribution";
	private final static String DEST_ID = "dest_id";
	private final static String DATE = "date";
	private final static String PRODUCT_ID = "product_id";
	private final static String MANAGER_ID = "mngr_id";
	private final static String CLIENT_ID = "clnt_id";
	private final static String DESTRIB_COMMENT ="destrib_comment";
	private final static String DEST_STATUS_ID = "dest_status_id";
	public static final int SELECT = 1;
	public static final int INSERT = 2;
	public static final int UPDATE = 3;
	public static final int DELETE = 4;
	private RdbDAOFactory nativeFactory;
	
	protected RdbDestributionDAO(RdbDAOFactory nativeFactory){
		this.nativeFactory = nativeFactory;
	}

	public int insertDestribution(Destribution destribution) {
		int flag = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(destribution,INSERT);
			System.out.println(query);
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
		return flag;
	}

	@Override
	public boolean deleteDestribution(Destribution destribution) {
		int flag = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(destribution,DELETE);
			System.out.println(query);
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
		if(flag == 0)
		return false;
		else return true;
	}


	public Destribution findDestribution(Destribution destribution) {
		Destribution findedDestrib = destribution;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(destribution,SELECT);
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
			if(!connection.isClosed())
				connection.close();
			findedDestrib = buildDestribution(resultSet);
			if(!statement.isClosed())
				statement.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return findedDestrib;
	}


	public boolean updateDestribution(Destribution destribution) {
		int flag = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(destribution,UPDATE);
			System.out.println(query);
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
//		List<Destribution> destList = new ArrayList<Destribution>();
//		try {
//			JDCConnection connection = RdbDAOFactory.createConnection();
//			Statement statement = connection.createStatement();
//			String query = buildQuery(destribution,SELECT);
//			System.out.println(query);
//			ResultSet resultSet = statement.executeQuery(query);
//			if(!connection.isClosed())
//				connection.close();
//			destList = buildDestributions(resultSet);
//			if(!statement.isClosed())
//				statement.close();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return null;
	}

	@Override
	public Collection<Destribution> selectDestributionsTO(Destribution destribution) {
		List<Destribution> destList = new ArrayList<Destribution>();
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(destribution,SELECT);
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
			
			if(!connection.isClosed())
				connection.close();
			destList = buildDestributions(resultSet);
			if(!statement.isClosed())
				statement.close();
			return destList;
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

	private Destribution buildDestribution(ResultSet rs){
		Destribution destribution;
		try {
			rs.next();
			destribution = new Destribution(rs.getInt(DEST_ID));		
			destribution.setDateTime(rs.getDate(DATE));
			destribution.setComment(rs.getString(DESTRIB_COMMENT));
			int destStatusId = rs.getInt(DEST_STATUS_ID);
			switch (destStatusId){
			case 3:
				destribution.setStatus(DestributionStatus.Завершено);
				break;
			case 4:
				destribution.setStatus(DestributionStatus.Ожидается);
				break;
			case 5:
				destribution.setStatus(DestributionStatus.Заморожено);
				break;
			case 6:
				destribution.setStatus(DestributionStatus.Отмена);
				break;
			}
			RdbClientDAO clientDAO = (RdbClientDAO) nativeFactory.getClientDAO();
			RdbManagerDAO managerDAO =  (RdbManagerDAO) nativeFactory.getManagerDAO();
			RdbProductDAO productDAO =  (RdbProductDAO) nativeFactory.getProductDAO();
			Client client = clientDAO.findClient(new Client(rs.getInt(CLIENT_ID)));
			Manager manager = managerDAO.findManager(new Manager(rs.getInt(MANAGER_ID)));
			Product product = productDAO.findProduct(new Product(rs.getInt(PRODUCT_ID)));
			destribution.setClient(client);
			destribution.setManager(manager);
			destribution.setProduct(product);
			destribution.setModelStatus(ModelStatus.Exist);
			return destribution;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	private  List<Destribution> buildDestributions(ResultSet rs){
		List<Destribution> destributions = new ArrayList<Destribution>();
		RdbClientDAO clientDAO = (RdbClientDAO) nativeFactory.getClientDAO();
		RdbManagerDAO managerDAO =  (RdbManagerDAO) nativeFactory.getManagerDAO();
		RdbProductDAO productDAO =  (RdbProductDAO) nativeFactory.getProductDAO();
		try {
			while(rs.next()){
			Destribution destribution = new Destribution(rs.getInt(DEST_ID));		
			destribution.setDateTime(rs.getDate(DATE));
			destribution.setComment(rs.getString(DESTRIB_COMMENT));
			int destStatusId = rs.getInt(DEST_STATUS_ID);
			switch (destStatusId){
			case 3:
				destribution.setStatus(DestributionStatus.Завершено);
				break;
			case 4:
				destribution.setStatus(DestributionStatus.Ожидается);
				break;
			case 5:
				destribution.setStatus(DestributionStatus.Заморожено);
				break;
			case 6:
				destribution.setStatus(DestributionStatus.Отмена);
				break;
			}
			Client client = clientDAO.findClient(new Client(rs.getInt(CLIENT_ID)));
			Manager manager = managerDAO.findManager(new Manager(rs.getInt(MANAGER_ID)));
			Product product = productDAO.findProduct(new Product(rs.getInt(PRODUCT_ID)));
			destribution.setClient(client);
			destribution.setManager(manager);
			destribution.setProduct(product);
			destribution.setModelStatus(ModelStatus.Exist);
			destributions.add(destribution);
			
			}
			return destributions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	public static String buildQuery(Destribution destribution,int queryType){
		
		Integer id = destribution.getDestributionId();
		List<String> columns = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		if(destribution.getProductId()!=null){
			columns.add(PRODUCT_ID);
			values.add((destribution.getProductId()).toString());
		}
		if(destribution.getDateTime()!=null){
			columns.add(DATE);
			java.text.SimpleDateFormat sdf = 
				     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(destribution.getDateTime());
			values.add(currentTime);
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
			return RdbDAOFactory.sql.buildSelect(DESTRIBUTION_TABLE, col, val);
		case UPDATE:
			return RdbDAOFactory.sql.buildUpdate(DESTRIBUTION_TABLE,col,val, DEST_ID, id);
		case DELETE:
			return RdbDAOFactory.sql.buildInvalidDelete(DESTRIBUTION_TABLE, DEST_ID, id, DEST_STATUS_ID);
		}
		
		return null;
	}
	
	
}
