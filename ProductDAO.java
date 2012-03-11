package model;

import java.util.Collection;

import javax.sql.RowSet;

public interface ProductDAO {
	
	public int insertProduct();
	public boolean deleteProduct();
	public Product findProduct();
	public boolean updateProduct();
	public RowSet selectProductsRS();
	public Collection<Product> selectProductsTO();

}
