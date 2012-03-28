package model;

import java.util.Collection;

import javax.sql.RowSet;

public class RdbProductDAO implements ProductDAO{

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product findProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RowSet selectProductsRS(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Product> selectProductsTO(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
