package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FetchStudent {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter ID:-");
		int id=scanner.nextInt();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root");
		
		PreparedStatement ps=connection.prepareStatement("SELECT * FROM STUDENT WHERE ID=?");
		
		ps.setInt(1,id);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("Id:-"+rs.getInt("id"));
			System.out.println("Name:-"+rs.getString("name"));
			System.out.println("Phone:-"+rs.getLong("phone"));
			System.out.println("Address:-"+rs.getString("address"));
			System.out.println("Marks:-"+rs.getInt("marks"));
		}
	}
}
