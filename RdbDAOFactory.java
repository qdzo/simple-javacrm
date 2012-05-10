package model;

import java.sql.SQLException;

public class RdbDAOFactory implements DAOFactoryInterface {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:jdc:mysql://192.168.0.2:3306/CRM_db"+
		 "?autoReconnect=true&characterEncoding=UTF-8&useUnicode=true";
	public static final String USER = "java";
	public static final String PSWD = "12345";
	private static JDCConnectionDriver connectionDriver;
	public static SQLBuilder sql = new SQLBuilder();
	private static PreConnector preConnector;
	
	
	public RdbDAOFactory(){
		preConnector = new PreConnector();
		preConnector.start();
	}
	
	public static JDCConnection createConnection() throws ClassNotFoundException, InstantiationException, 
	IllegalAccessException, SQLException{
		
		if(connectionDriver == null)
			{
			connectionDriver = new JDCConnectionDriver(DRIVER,DBURL,USER,PSWD);
			}
		return 	connectionDriver.connect(DBURL, null);
	}		
	

	


	public ClientDAO getClientDAO(){
		
		return new RdbClientDAO();
	}	

	
	public ManagerDAO getManagerDAO(){
		
		return new RdbManagerDAO();
	}

	
	
	public DestributionDAO getDestributionDAO(){
		
		return new RdbDestributionDAO(this);
	}

	

	
	public ProductDAO getProductDAO(){
		
		return new RdbProductDAO();
	}

	private class PreConnector extends Thread {
		
		PreConnector(){
		}
		
		public void run(){
			try {
				JDCConnection connection = RdbDAOFactory.createConnection();
				connection.close();
				System.out.println("Creating pre-connection to DB...OK!");
			} catch (ClassNotFoundException e) {
				System.out.println("Creating pre-connection to DB...ERROR!");
			} catch (InstantiationException e) {
				System.out.println("Creating pre-connection to DB...ERROR!");
			} catch (IllegalAccessException e) {
				System.out.println("Creating pre-connection to DB...ERROR!");
			} catch (SQLException e) {
				System.out.println("Creating pre-connection to DB...ERROR!");
			}

		}
	}
	
	
}
