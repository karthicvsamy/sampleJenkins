package jdbc.Mysql.JavaConnection.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class MySqlDatabasePractice {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/alpha_shoppee", "root", "root");
		
		Statement statement = connect.createStatement();
		
		ResultSet result = statement.executeQuery("select * from users;");
		
		while (result.next()) {
			for(int i=1;i<5;i++) {
				System.out.print(result.getString(i)+" ");
			}
		System.out.println();
		}
		
		connect.close();
	}
}
