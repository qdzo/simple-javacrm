package model;

import java.sql.SQLException;

public class RdbDAOFactory implements DAOFactoryInterface {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:jdc:mysql://192.160.0.2/crm_db"+
		 "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
	public static final String USER = "java";
	public static final String PSWD = "12345";
	private static JDCConnectionDriver ConnectionDriver;
	
	
	public static JDCConnection createConnection() throws ClassNotFoundException, InstantiationException, 
	IllegalAccessException, SQLException{
		
		if(ConnectionDriver == null)
			if(ConnectionDriver.acceptsURL(DBURL)){
			ConnectionDriver = new JDCConnectionDriver(DRIVER,DBURL,USER,PSWD);
			}
		return 	ConnectionDriver.connect(DBURL, null);
	}		
	

	


	public ClientDAO getClientDAO(){
		
		return new RdbClientDAO();
	}	

	
	public ManagerDAO getManagerDAO(){
		
		return new RdbManagerDAO();
	}

	
	
	public DestributionDAO getDestributionDAO(){
		
		return new RdbDestributionDAO();
	}

	

	
	public ProductDAO getProductDAO(){
		
		return new RdbProductDAO();
	}

	
	
	
}
