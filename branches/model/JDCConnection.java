package model;

import java.sql.*;
import java.util.*;
import java.io.*;

public class JDCConnection implements Connection {
	
	private JDCConnectionPool pool;
	private Connection connection;
	private boolean inuse;
	private long timestamp;
	
	public JDCConnection(Connection conn, JDCConnectionPool pool){
		
		this.connection = conn;
		this.pool = pool;
		inuse = false;
		timestamp = 0;
	}
	
	public synchronized boolean lease(){
		
		if(inuse){
			return false;
		} else {
			inuse = true;
			timestamp = System.currentTimeMillis();
			return true;
		}
	}
	
	public boolean validate(){
		
		try{
			conn.getMetaData();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public boolean inUse(){
		return inuse;
	}
	
	public long getLastUse(){
		return timestamp;
	}
	
	public void close(){
		pool.returnCoonection(this);
	}
	
	protected void expireLease(){
		inuse = false;
	}
	
	protected Connection getConnection(){
		return connection;
	}
	
	public PrepearedStatement prepareStatement(String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}
	
	public CallableStatement prepeareCall(String sql) throws SQLException {
		return connection.prepareCall(sql);
	}
	
	public Statement createStatement() throws SQLException {
		return connection.createStatement();
	}
	
	public String nativeSQL(String sql) throws SQLException {
		return connection.nativeSQL(sql);
	}
	
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		connection.setAutoCommit(autoCommit);
	}
	
	public boolean getAutoCommit() throws SQLException{
		return connection.getAutoCommit();
	}
	
	public void commit() throws SQLException{
		connection.commit();
	}
	
	public void rollback() throws SQLException{
		connection.rollback();
	}
	
	public boolean isClosed() throws SQLException{
		return connection.isClosed();
	}
	
	public DatabaseMetaData getMetaData() throws SQLExcepion {
		return connection.getMetaData();
	}
	
	public void setReadOnly(boolean readOnly) throws SQLException {
		connection.setReadOnly(readOnly);
	}
	
	public boolean isReadOnly() throws SQLException {
		return connection.isReadOnly();
	}
	
	public void setCatalog(String catalog) throws SQLException {
		connection.setCatalog(catalog);
	}
	
	public String getCatalog() throws SQLException{
		return connection.getCatalog();
	}
	
	public void setTransactionIsolation(int level) throws SQLException {
		connection.setTransactionIsolation(level);
	}
	
	public int getTransactionIsolation() throws SQLException{
		connection.getTransactionIsolation();
	}
	
	public SQLWarning getWarnings() throws SQLException {
		connection.getWarnings();
	}
	
	public void clearWarnings() throws SQLException {
		connection.clearWarnings();
	}
}