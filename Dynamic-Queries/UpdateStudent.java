package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdateStudent {

		public static void main(String[] args) throws Exception {
			
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter ID:-");
			int id=scanner.nextInt();
			String name=scanner.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root");
			
			PreparedStatement ps=connection.prepareStatement("UPDATE STUDENT NAME=? WHERE ID=?");
			
			ps.setInt(2,id);
			ps.setString(1,name);
			ps.executeUpdate();
			connection.close();
		}
}
