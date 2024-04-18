package jdbc.Mysql.JavaConnection.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class MySqlQueryPracticeTest {
	
	public static void main(String[] args) throws SQLException {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/alpha_shoppee","root","root");
		
		Statement state = connect.createStatement();
		
//		System.out.println(state.executeUpdate("create table admin_login(slno int(3), Admin_name varchar(15), Admin_access varchar(3), Admin_status varchar(12));"));
		String query = "insert into admin_login values('1','Manager_man','yes','active');";
		
		System.out.println(state.executeUpdate(query));
		connect.close();
		
	}

}
