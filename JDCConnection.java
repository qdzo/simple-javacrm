package model;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;

import model.JDCConnectionPool;

public class JDCConnection implements Connection {
	
	private JDCConnectionPool pool;
	private Connection connection;
	private boolean inuse;
	private long timestamp;
	
	public JDCConnection(Connection conn, JDCConnectionPool pool){
		
		this.connection = conn;
		this.pool = pool;
		this.inuse = false;
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
			connection.getMetaData();
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
		this.pool.returnConnection(this);
	}
	
	public void expireLease(){
		this.inuse = false;
	}
	
	protected Connection getConnection(){
		return connection;
	}
	
	public PreparedStatement prepareStatement(String sql) throws SQLException {
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
	
	public DatabaseMetaData getMetaData() throws SQLException {
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
		return connection.getTransactionIsolation();
	}
	
	public SQLWarning getWarnings() throws SQLException {
		return connection.getWarnings();
	}
	
	public void clearWarnings() throws SQLException {
		connection.clearWarnings();
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createStatement(int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHoldability(int holdability) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rollback(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Statement createStatement(int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid(int timeout) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setClientInfo(String name, String value)
			throws SQLClientInfoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setClientInfo(Properties properties)
			throws SQLClientInfoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getClientInfo(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Array createArrayOf(String typeName, Object[] elements)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Struct createStruct(String typeName, Object[] attributes)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}