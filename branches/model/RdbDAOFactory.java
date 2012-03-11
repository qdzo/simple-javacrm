package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RdbDAOFactory implements DAOFactoryInterface {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost/CRM_db"+
		 "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
	public static final String USER = "java";
	public static final String PSWD = "12345";
	private static Connection connection;
	
//===============================================Start of createConnection=================================================	
	public Connection createConnection(){
		
		if(connection == null){
		
			try{
				Class.forName(DRIVER);
				System.out.println("Driver loading success!");
				try {
					connection = DriverManager.getConnection(DBURL,USER,PSWD);
					System.out.println("Database Connected!");
					} catch (SQLException e) 
					{
						e.printStackTrace();
					}
			} catch(ClassNotFoundException e){
				e.printStackTrace();
				}	
		}

		return connection;
	}
	
//-----------------------------------------------End of createConnection-----------------------------------------------------
	
	
//===============================================Start of getClientDAO=======================================================	
	public ClientDAO getClientDAO(){
		
		return new RdbClientDAO();
	}	
//-------------------------------------------------End of getClientDAO-------------------------------------------------------
	
//=================================================Start of getManagerDAO====================================================
	public ManagerDAO getManagerDAO(){
		
		return new RdbManagerDAO();
	}
//--------------------------------------------------End of getManagerDAO-----------------------------------------------------
	
//=================================================Start of getDestributionDAO===============================================
	
	public DestributionDAO getDestributionDAO(){
		
		return new RdbDestributionDAO();
	}
//-------------------------------------------------End of getDestributionDAO-------------------------------------------------
	
//==================================================Start of getProductDAO---------------------------------------------------
	
	public ProductDAO getProductDAO(){
		
		return new RdbProductDAO();
	}
//--------------------------------------------------End of getProductDAO-----------------------------------------------------
	
	
	
}
