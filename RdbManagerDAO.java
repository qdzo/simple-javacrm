package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import javax.sql.RowSet;

public class RdbManagerDAO implements ManagerDAO{

	private final static String INSERT = "insert into person(first_name,second_name,tel,email,belong,priority) values (";
	private final static String SEMICOLON = ");";
	private final static String SELECT = "select * from person where ";
	private final static String UPDATE = "update person set ";
	private final static String DELETE = "delete from person where pers_id = ";
	private final static String QUOTES = "\'";
	private final static String QUOTES_WITH_COMMA = "\',\'";
	private final static String WHERE = "where ";
	
	@Override
	public int insertManager(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean deleteManager(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Manager findManager(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateManager(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public RowSet selectManagersRS(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<Manager> selectManagersTO(Manager manager) {
		// TODO Auto-generated method stub
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			
			
			
			ResultSet resultSet = statement.executeQuery(null);
			if(!statement.isClosed())
				statement.close();
			if(connection.isClosed())
				connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}