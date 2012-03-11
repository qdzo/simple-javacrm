package model;

public interface DAOFactoryInterface {

	public ClientDAO getClientDAO();
	public DestributionDAO getDestributionDAO();
	public ManagerDAO getManagerDAO();
	public ProductDAO getProductDAO();
}
