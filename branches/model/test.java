package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:jdc:mysql://localhost/CRM_db"+
		 "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
	public static final String USER = "java";
	public static final String PSWD = "12345";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			JDCConnectionDriver conDrive = new JDCConnectionDriver(DRIVER,DBURL,USER,PSWD);
			JDCConnection connection = conDrive.connect(DBURL, null);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from person where pers_id=2;");
		    ResultSetMetaData metaData = resultSet.getMetaData();
		    for(int i=1;i<metaData.getColumnCount();i++)
			System.out.println(resultSet.getString(i));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
