package model;

import java.util.Collection;

import javax.sql.RowSet;



// интерфейс для объектов ManagerDAO

public interface ManagerDAO {
	
	public int insertManager();
	public boolean deleteManager();
	public Manager findManager();
	public boolean updateManager();
	public RowSet selectManagersRS();
	public Collection<Manager> selectManagersTO();

}
