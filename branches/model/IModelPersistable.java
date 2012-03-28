package model;

import java.util.Collection;

import javax.sql.RowSet;

public interface IModelPersistable {
	
	public void insert(Object t);
	public void delete(Object t);
	public Object find(Object e);
	public boolean update(Object t);
	public RowSet selectRS(Object t);
	public Collection<? extends Object> selectTO(Object t);

}
