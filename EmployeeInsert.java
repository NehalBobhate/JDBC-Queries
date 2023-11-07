package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//1.Load or Register the Driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2.Establish Connection
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
		
		//3.Creating statements
		
		Statement statement=connection.createStatement();
		
		//4. Execute Statements or Process the result.
		
		int count=statement.executeUpdate("INSERT INTO EMPLOYEE VALUES(3,'RAJU',7500,8691542109,'DECCAN')");
		
		if (count==1) {
			System.out.println("Data Inserted Successfully!!");
		} else {
			System.out.println("Data Insertion Failed!!");

		}
		//5.Close Connection
		
		connection.close();
	}
}
