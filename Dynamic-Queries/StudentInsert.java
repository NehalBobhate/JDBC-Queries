package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentInsert {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Student id:-");
		int id=scanner.nextInt();
		
		System.out.println("Enter Student name:-");
		String name=scanner.next();
		
		System.out.println("Enter Phone Number:-");
		long phone=scanner.nextLong();
		
		System.out.println("Enter Address;-");
		String address=scanner.next();
		
		System.out.println("Enter Marks:-");
		int marks=scanner.nextInt();
		
		//1.Load/Register the Driver:
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//2.Establish Connection:
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root");
		
		//3.Create Statement:
		
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?)");
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setLong(3, phone);
		preparedStatement.setString(4, address);
		preparedStatement.setInt(5, marks);
		
		//4.Execute Statements:
		
		int count=preparedStatement.executeUpdate();
		if (count!=0) {
			System.out.println("DATA INSERTED SUCCESSFULLY");
		}
		else
		{
			System.out.println("DATA INSERTION FAILED");
		}
		
		
		
	}
}
