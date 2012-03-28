package model;

import java.util.Collection;

import javax.sql.RowSet;



// интерфейс для объектов ManagerDAO

public interface ManagerDAO {
	
	public int insertManager(Manager manager);
	public boolean deleteManager(Manager manager);
	public Manager findManager(Manager manager);
	public boolean updateManager(Manager manager);
	public RowSet selectManagersRS(Manager manager);
	public Collection<Manager> selectManagersTO(Manager manager);

}
