package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateEmployee {

	public static void main(String[] args) throws Exception {
		
		String className="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/employeedb";
		String userName="root";
		String passWord="root";
		String query="UPDATE EMPLOYEE SET NAME='RAJI' WHERE ID='2'";
		
		Class.forName(className);
		
		Connection connection=DriverManager.getConnection(url, userName, passWord);
		
		Statement statement =connection.createStatement();
		
		int count=statement.executeUpdate(query);
		
		if (count==1) {
			System.out.println("Data Updated Successfully!!");
			
		}
		else
		{
			System.out.println("Data Updation Failed!");
		}
		
	}
}
