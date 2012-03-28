package model;

import java.util.Collection;

import javax.sql.RowSet;

public interface ProductDAO {
	
	public int insertProduct(Product product);
	public boolean deleteProduct(Product product);
	public Product findProduct(Product product);
	public boolean updateProduct(Product product);
	public RowSet selectProductsRS(Product product);
	public Collection<Product> selectProductsTO(Product product);

}
