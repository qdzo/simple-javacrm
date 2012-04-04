package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:jdc:mysql://192.168.0.2:3306/CRM_db";
//	+ "?autoReconnect=true&useUnicode=true&characterEncoding=utf8";
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
			System.out.println("Connection is created");
			Statement statement = connection.createStatement();
			System.out.println("Statement is created");
			ResultSet resultSet = statement.executeQuery("select * from person where pers_id=20;");
			System.out.println("send query");
//		    ResultSetMetaData metaData = resultSet.getMetaData();
//		    for(int i=1;i<metaData.getColumnCount();i++)
//			System.out.println(resultSet.getString(i));
		    printRes(resultSet);
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
	
	
	private static void printRes(ResultSet rs) throws SQLException {
		String first_name;
		String second_name;
		String tel;
		String email;
		int priority;
		while(rs.next()){
			first_name = rs.getString("first_name");
			second_name = rs.getString("second_name");
			tel = rs.getString("tel");
			email = rs.getString("email");
			priority = rs.getInt("priority");
			System.out.println("*******************************************************");
			System.out.println("first name: "+first_name);
			System.out.println("second_name: "+second_name);
			System.out.println("telephone: "+tel);
			System.out.println("email: "+email);
			System.out.println("priority: "+priority);
			System.out.println("*******************************************************");
		}
	}
	


}
