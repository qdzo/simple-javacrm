package model;

import java.sql.SQLException;

public class RdbDAOFactory implements DAOFactoryInterface {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:jdc:mysql://192.168.0.2:3306/CRM_db"+
		 "?autoReconnect=true&characterEncoding=UTF-8&useUnicode=true";
	public static final String USER = "java";
	public static final String PSWD = "12345";
	private static JDCConnectionDriver ConnectionDriver;
	public static SQLBuilder sql = new SQLBuilder();
	
	public static JDCConnection createConnection() throws ClassNotFoundException, InstantiationException, 
	IllegalAccessException, SQLException{
		
		if(ConnectionDriver == null)
			//if(ConnectionDriver.acceptsURL(DBURL))
			{
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
