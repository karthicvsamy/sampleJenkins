package jdbc.Mysql.JavaConnection.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertValuesIntoTableTest {

	public static void main(String[] args) throws SQLException {
		
		//register the driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection with the database
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/alpha_shoppee", "root", "root");
		
//		create statement
		Statement stateObj = connect.createStatement();
		String query = "insert into users values('4','am_i_a_joke','aiaj','successful');";
		
		//execute the statement
		int result = stateObj.executeUpdate(query);
		System.out.println(result);
		
		//close the connection
		connect.close();
		
	}
}
