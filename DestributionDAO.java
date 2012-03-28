package model;

import java.util.Collection;

import javax.sql.RowSet;

public interface DestributionDAO {
	
	public int insertDestribution(Destribution destribution);
	public boolean deleteDestribution(Destribution destribution);
	public Destribution findDestribution(Destribution destribution);
	public boolean updateDestribution(Destribution destribution);
	public RowSet selectDestributionsRS(Destribution destribution);
	public Collection<Destribution> selectDestributionsTO(Destribution destribution);

}
