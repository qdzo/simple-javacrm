package model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
	
	SQLBuilder sqlBuilder = new SQLBuilder();
	RdbManagerDAO managerDAO = new RdbManagerDAO();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Manager manager = new Manager(16);
		manager.setFirstName("Vladimir");
		manager.setSecondName("Banchenko");
		manager.setTelephone("876537281");
		String query = RdbManagerDAO.buildQuery(manager,RdbManagerDAO.SELECT);
		System.out.println(query);
		
			
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
