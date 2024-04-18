package jdbc.Mysql.JavaConnection.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryParacticeJdbcMysqlPractice {

	public static void main(String[] args) throws SQLException {
		
		//register the sqlDriver from  cj.jdbc
 		Driver driver = new Driver();
 		DriverManager.registerDriver(driver);
 		
 		//get connection for database with the java.sql
 		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/alpha_shoppee", "root", "root");
 		
 		//create statement
 		Statement state = con.createStatement();
 		String query = "select * from users;";
 		
 		//execute the statement and store it in ResultSet
 		ResultSet result = state.executeQuery(query);
 		while(result.next()) {
 			System.out.println( result.getString(1)+" "+ result.getString(2)+" "+ result.getString(3));
 		}
 		
 		//close the connection
 		con.close();
 		
	}
	
}
