package model;

import java.sql.*;
import java.util.*;
import model.JDCConnectionPool;


public class JDCConnectionDriver implements java.sql.Driver{
	
	public static final String URL_PREFIX = "jdbc:jdc:";
	private static final int MAGOR_VERSION = 1;
	private static final int MINOR_VERSION = 0;
	private JDCConnectionPool pool;
	
	public JDCConnectionDriver(String driver, String url, String user, String password) throws ClassNotFoundException, 
	InstantiationException, IllegalAccessException, SQLException {
		
		DriverManager.registerDriver(this);
		Class.forName(driver).newInstance();
		pool = new JDCConnectionPool(url, user, password);
	}
	
	public Connection connect(String url, Properties props) throws SQLException {
		
		if(!url.startsWith(URL_PREFIX)){
			return null;
		}
		return (JDCConnection)pool.getConnection();
	}
	
	public boolean acceptsURL(String url) {
		return url.startsWith(URL_PREFIX);
	}
	
	public int getMajorVersion(){
		return MAGOR_VERSION;
	}
	
	public int getMinorVersion(){
		return MINOR_VERSION;
	}
	
	public DriverPropertyInfo[] getPropertyInfo(String string, Properties props){
		return new DriverPropertyInfo[0];
	}

	public boolean jdbcCompliant(){
		return false;
	}

}