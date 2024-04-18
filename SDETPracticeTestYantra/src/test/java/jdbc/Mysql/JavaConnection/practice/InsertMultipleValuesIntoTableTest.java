package jdbc.Mysql.JavaConnection.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertMultipleValuesIntoTableTest {

	public static void main(String[] args) throws SQLException {
		
		//register the driver with driver manager
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//create connection and get connection with the database through driver manager
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/alpha_shoppee","root","root");
		
		//create a new statement using the connection object
		Statement statement = connect.createStatement();
		String query = "insert into users values('5','open_and_wink','oaw','successful'),('6','stare_and_smile','sas','successful');";
		
		//execute the query using the statement
		int result = statement.executeUpdate(query);
		System.out.println(result);
		
		//close the connection
		connect.close();
		
	}
}
