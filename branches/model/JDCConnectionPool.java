package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;
import model.JDCConnection;


 class ConnectionReaper extends Thread {
	
	private JDCConnectionPool pool;
	private final long delay = 300000;
	
	ConnectionReaper(JDCConnectionPool pool){
		this.pool = pool;
	}
	
	public void run(){
		while(true){
			try{
				sleep(delay);
			} catch(InterruptedException e){}
			pool.reapConnections();
		}
	}
}


public class JDCConnectionPool{
	
	private Vector<JDCConnection> connections;
	private String url, user, password;
	private final long timeout = 60000;
	private ConnectionReaper reaper;
	private final int poolsize = 10;
	
	public JDCConnectionPool(String url, String user, String password){
		
		this.url = url;
		this.user = user;
		this.password = password;
		connections = new Vector<JDCConnection>(poolsize);
		reaper = new ConnectionReaper(this);
		reaper.start();
	}
	
	public synchronized void reapConnections(){
		
		long stale = System.currentTimeMillis() - timeout;
		Enumeration<JDCConnection> connlist = connections.elements();
		
		while((connlist != null) && (connlist.hasMoreElements())){
			JDCConnection conn = (JDCConnection) connlist.nextElement();
			if((conn.inUse()) && (stale>conn.getLastUse()) && (!conn.validate())){
				removeConnection(conn);
			}
		}
	}
	
	public synchronized void closeConnections(JDCConnection conn){
		
		Enumeration<JDCConnection> connlist = connections.elements();
		
		while((connlist != null) && (connlist.hasMoreElements())){
			JDCConnection conn1 = (JDCConnection)connlist.nextElement();
			removeConnection(conn1);
		}
	}
	
	private synchronized void removeConnection(JDCConnection conn){
		connections.removeElement(conn);
	}
	
	public synchronized JDCConnection getConnection() throws SQLException {
		
		JDCConnection c;
		for(int i = 0; i<connections.size(); i++){
			c = (JDCConnection)connections.elementAt(i);
			if(c.lease()) {
				return c;
			}
		}
		String jdbcUrl = "jdbc:";
		jdbcUrl+= url.substring(url.indexOf("mysql"));
		System.out.println(jdbcUrl);
		Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
		c = new JDCConnection(conn, this);
		c.lease();
		connections.addElement(c);
		return c;
	}
	
	public synchronized void returnConnection(Connection conn){
		((JDCConnection) conn).expireLease();
	}
}