package model;

import java.sql.*;
import java.util.*;

public class JDCConnectionDriver implements java.sql.Driver{
	
	public static final String URL_PREFIX = "jdbc:jdc:";
	private static final int MAGOR_VERSION = 1;
	private static final int MINOR_VERSION = 0;
	private JDCConnectionPool pool;
	
	public JDCConnectionDriver(String driver, String url, String user, String password) throws ClassNotFoundException, 
	InstantinationException, IllegalAccessException, SQLException {
		
		DriverManager.registerDriver(this);
		Class.forName(driver).newInstance();
		pool = new JDCConnectionPool(url, user, password);
	}
	
	public Connection connect(String url, Properties props) throw SQLException {
		
		if(!url.startsWith(URL_PREFIX)){
			return null;
		}
		return pool.getConnection();
	}
	
	public boolean acceptsURL(Sting url) {
		return url.startWith(URL_PREFIX);
	}
	
	public int getMagorVersion(){
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