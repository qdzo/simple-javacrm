package model;

public class SQLBuilder {
	
	
	public String buildDelete(String tableName,String columnIdName,int id){
		String sql = "DELETE FROM "+tableName+" WHERE "+columnIdName+"="+id+";";
		return sql;
	}
	
	public String buildInvalidDelete(String tableName,String columnIdName,int id,String statusColumn) {
		String sql = "UPDATE "+tableName+" SET "+statusColumn+" = 2 WHERE "+columnIdName+" = "+id+";";
		return sql;
	}

	
	public String buildUpdate(String tableName,String[] columns, String[] values,String columnId,int id) {
		String sql = "UPDATE "+tableName+" SET ";
			for(int i=0;i<columns.length;i++){
				sql+= columns[i]+ "=\""+values[i]+"\"";
				if(i+1<columns.length)
					sql+= ",";
		 }
		 sql +=" WHERE "+columnId+"="+id+";";
		return sql;
	}

	
	public String buildInsert(String tableName, String[] columns,String[] values) {
		String sql = "INSERT INTO "+tableName+"(";
		for(int i=0;i<columns.length;i++){
			sql+=columns[i];
			if(i+1<columns.length)
				sql+=",";
		}
		sql+= ") VALUES (\'";
		for(int i=0;i<columns.length;i++){
			sql+= values[i]+"\'";
			if(i+1<columns.length)
				sql+=",\'";
		}
		sql+=");";
		return sql;
	}

	
	public String buildSelect(String tableName,String[] columns,String[] values){
		String sql = "SELECT * FROM "+tableName;
		if(columns.length>0)
			sql+=" WHERE ";
		for(int i=0;i<columns.length;i++){
			sql+= columns[i]+ "=\""+values[i]+"\"";
			if(i+1<columns.length)
				sql+= " AND ";
	 }
	 sql +=";";
	return sql;
	}
	
	public String buildSmartSelect(String[] selectedColumns,String[] tableNames,String[] equivalentColumns,String[] columns,String[] values){
		String sql = "SELECT ";
		for(int i=0;i<selectedColumns.length;i++){
			sql+=selectedColumns[i];
			if(i+1<selectedColumns.length)
				sql+=",";
		}
		sql+=" FROM "+tableNames[0];
		for(int i=0;i<tableNames.length;i++){
			sql+= " LEFT OUTER JOIN "+tableNames[i+1]+" ON "+ equivalentColumns[i];
		}
		if(columns.length>0)
			sql+=" WHERE ";
		for(int i=0;i<columns.length;i++){
			sql+=columns[i]+"="+values[i];
			if(i+1<columns.length)
				sql+= " AND ";
		}
		sql+=";";
		return sql;
	}

}
