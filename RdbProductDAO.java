package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.RowSet;
public class RdbProductDAO implements ProductDAO{

	private final static String TABLE_NAME = "product";
	private final static String PROD_ID = "prod_id";
	private final static String PROD_NAME = "prod_name";
	private final static String PROD_COST = "prod_cost";
	private final static String PROD_VALUE = "prod_value";
	private final static String PROD_DESCRIPTION = "prod_description";
	public static final int SELECT = 1;
	public static final int INSERT = 2;
	public static final int UPDATE = 3;
	public static final int DELETE = 4;
	
	@Override
	public int insertProduct(Product product) {
		int id = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(product,INSERT);
			System.out.println(query);
			id = statement.executeUpdate(query);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}


	public boolean deleteProduct(Product product) {
		int flag = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(product,DELETE);
			System.out.println(query);
			flag = statement.executeUpdate(query);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag==0)
			return true;
		return false;
	}

	
	public Product findProduct(Product product) {
		Product findedProduct = null;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(product,SELECT);
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
			findedProduct = buildProduct(resultSet);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return findedProduct;
	}

	public boolean updateProduct(Product product) {
		int flag = 0;
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(product,UPDATE);
			System.out.println(query);
			flag = statement.executeUpdate(query);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(flag==1)
			return true;
		return false;
	}

	// этот метод не реализован полностью, за ненадобностью .
	public RowSet selectProductsRS(Product product) {
		
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(product,SELECT);
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<Product> selectProductsTO(Product product) {
		Collection<Product> productsCollection = new ArrayList<Product>();
		try {
			JDCConnection connection = RdbDAOFactory.createConnection();
			Statement statement = connection.createStatement();
			String query = buildQuery(product,SELECT);
			System.out.println(query);
			ResultSet resultSet = statement.executeQuery(query);
			productsCollection = buildProducts(resultSet);
			if(!statement.isClosed())
				statement.close();
			if(!connection.isClosed())
				connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productsCollection;
	}
	
	private static Product buildProduct(ResultSet rs){
		Product product;
		try {
			rs.next();
			product = new Product(rs.getInt(PROD_ID));
			product.setNameProduct(rs.getString(PROD_NAME));
			Integer price = rs.getInt(PROD_COST);
			product.setPrice(price.toString());
			Integer summary = rs.getInt(PROD_VALUE);
			product.setSummary(summary.toString());
			product.setDescription(rs.getString(PROD_DESCRIPTION));		
			product.setModelStatus(ModelStatus.Exist);
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	private static Collection<Product> buildProducts(ResultSet rs){
		Collection<Product> productsCollection = new ArrayList<Product>();
		try {
			while(rs.next()){
				Product product = new Product(rs.getInt(PROD_ID));
				product.setNameProduct(rs.getString(PROD_NAME));
				Integer price = rs.getInt(PROD_COST);
				product.setPrice(price.toString());
				Integer summary = rs.getInt(PROD_VALUE);
				product.setSummary(summary.toString());
				product.setDescription(rs.getString(PROD_DESCRIPTION));		
				product.setModelStatus(ModelStatus.Exist);
				productsCollection.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productsCollection;
	}

	
	public static String buildQuery(Product product,int queryType){
		
		Integer id = product.getProductId();
		List<String> columns = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		if(product.getNameProduct()!=null){
			columns.add(PROD_NAME);
			values.add(product.getNameProduct());
		}
		if(product.getPrice()!=null){
			columns.add(PROD_COST);
			values.add((product.getPrice()).toString());
		}
		if(product.getSummary()!=null){
			columns.add(PROD_VALUE);
			values.add((product.getSummary()).toString());
		}
		if(product.getDescription()!=null){
			columns.add(PROD_DESCRIPTION);
			values.add(product.getDescription());
		}
		String[] col =  new String[columns.size()];
		String [] val = new String[values.size()];
		for(int i=0;i<columns.size();i++){
			col[i]=columns.get(i);
			val[i]=values.get(i);
		}
		switch(queryType){
		case INSERT:
			return RdbDAOFactory.sql.buildInsert(TABLE_NAME,col,val);
		case SELECT:
			return RdbDAOFactory.sql.buildSelect(TABLE_NAME,col,val);
		case UPDATE:
			return RdbDAOFactory.sql.buildUpdate(TABLE_NAME,col,val, PROD_ID, id);
		case DELETE:
			return RdbDAOFactory.sql.buildDelete(TABLE_NAME, PROD_ID, id);
		}
		
		return null;
	}

}
