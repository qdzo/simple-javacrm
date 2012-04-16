package model;

import java.util.Collection;

import javax.sql.RowSet;

public class Model implements IModelPersistable {
	
	RdbDAOFactory daoFactory;
	ClientDAO	clientDAO; 
	ManagerDAO	managerDAO;
	ProductDAO	productDAO;
	DestributionDAO	destributionDAO;
	
	
	public Model(){
		daoFactory = new RdbDAOFactory();
		clientDAO = daoFactory.getClientDAO();
		managerDAO = daoFactory.getManagerDAO();
		productDAO = daoFactory.getProductDAO();
		destributionDAO = daoFactory.getDestributionDAO();
	}


	@Override
	public void insert(Object t) {
		if(t==null)
			throw new NullPointerException("Empty argument set in Model method");
		if(t.getClass().equals(model.Client.class)){
			clientDAO.insertClient((Client)t);
		}
		if(t.getClass().equals(model.Manager.class)){
			managerDAO.insertManager((Manager)t);
		}
		if(t.getClass().equals(model.Product.class)){
			productDAO.insertProduct((Product)t);
		}
		if(t.getClass().equals(model.Destribution.class)){
			destributionDAO.insertDestribution((Destribution)t);
		}
		
	}


	@Override
	public void delete(Object t) {
		if(t==null)
			throw new NullPointerException("Empty argument set in Model method");
		if(t.getClass().equals(model.Client.class)){
			clientDAO.deleteClient((Client)t);
		}
		if(t.getClass().equals(model.Manager.class)){
			managerDAO.deleteManager((Manager)t);
		}
		if(t.getClass().equals(model.Product.class)){
			productDAO.deleteProduct((Product)t);
		}
		if(t.getClass().equals(model.Destribution.class)){
			destributionDAO.deleteDestribution((Destribution)t);
		}
	}


	@Override
	public Object find(Object t) {
		if(t==null)
			throw new NullPointerException("Empty argument set in Model method");
		if(t.getClass().equals(model.Client.class)){
			return clientDAO.findClient((Client)t);
		}
		if(t.getClass().equals(model.Manager.class)){
			return managerDAO.findManager((Manager)t);
		}
		if(t.getClass().equals(model.Product.class)){
			return productDAO.findProduct((Product)t);
		}
		if(t.getClass().equals(model.Destribution.class)){
			return destributionDAO.findDestribution((Destribution)t);
		} else return null;
	}


	@Override
	public boolean update(Object t) {
		if(t==null)
			throw new NullPointerException("Empty argument set in Model method");
		if(t.getClass().equals(model.Client.class)){
			return clientDAO.updateClient((Client)t);
		}
		if(t.getClass().equals(model.Manager.class)){
			return managerDAO.updateManager((Manager)t);
		}
		if(t.getClass().equals(model.Product.class)){
			return productDAO.updateProduct((Product)t);
		}
		if(t.getClass().equals(model.Destribution.class)){
			return destributionDAO.updateDestribution((Destribution)t);
		} else return false;
	}


	@Override
	public RowSet selectRS(Object t) {
		if(t==null)
			throw new NullPointerException("Empty argument set in Model method");
		if(t.getClass().equals(model.Client.class)){
			return clientDAO.selectClientsRS((Client)t);
		}
		if(t.getClass().equals(model.Manager.class)){
			return managerDAO.selectManagersRS((Manager)t);
		}
		if(t.getClass().equals(model.Product.class)){
			return productDAO.selectProductsRS((Product)t);
		}
		if(t.getClass().equals(model.Destribution.class)){
			return destributionDAO.selectDestributionsRS((Destribution)t);
		} else return null;
	}


	@Override
	public Collection<? extends Object> selectTO(Object t) {
		if(t==null)
			throw new NullPointerException("Empty argument set in Model method");
		if(t.getClass().equals(model.Client.class)){
			return clientDAO.selectClientsTO((Client)t);
		}
		if(t.getClass().equals(model.Manager.class)){
			return managerDAO.selectManagersTO((Manager)t);
		}
		if(t.getClass().equals(model.Product.class)){
			return productDAO.selectProductsTO((Product)t);
		}
		if(t.getClass().equals(model.Destribution.class)){
			return destributionDAO.selectDestributionsTO((Destribution)t);
		} else return null;
	}
}
