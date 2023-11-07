package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteEmployee {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
		
		Statement statement=connection.createStatement();
		
		int count=statement.executeUpdate("DELETE FROM EMPLOYEE WHERE ID=3");
		
		if (count==1) {
			System.out.println("Data Deleted Successfully!");
		}
		else
		{
			System.out.println("Data Deletion Failed!!");
		}
		
		connection.close();
		
	}
}
