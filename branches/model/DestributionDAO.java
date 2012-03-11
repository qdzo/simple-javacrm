package model;

import java.util.Collection;

import javax.sql.RowSet;

public interface DestributionDAO {
	
	public int insertDestribution();
	public boolean deleteDestribution();
	public Destribution findDestribution();
	public boolean updateDestribution();
	public RowSet selectDestributionsRS();
	public Collection<Destribution> selectDestributionsTO();

}
