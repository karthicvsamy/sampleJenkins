package com.alphaShoppee.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	Connection connect = null;
	
	public void openConnectionToDataBase(String url, String username, String password) throws SQLException {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connect = DriverManager.getConnection(ProjectConstant.databaseUrl,ProjectConstant.databaseUsername,ProjectConstant.databasePassword);
		
	}
	
	public ResultSet executeTheQuery(String query) throws SQLException {
		
		Statement state = connect.createStatement();
		ResultSet result = state.executeQuery(query);
		return result;
		
	}
	
	public boolean executeAndVerifyDataIsPresent(String query, String data, int colIndex) throws SQLException {
		
		ResultSet result = executeTheQuery(query);
		ResultSetMetaData metaResult = result.getMetaData();
		int colCount = metaResult.getColumnCount();
		if(colIndex<=colCount) {
			while(result.next()) {
				if(result.getString(colIndex+1).equals(data)) {
					return true;
				}
			}
			return false;
		}
		else {
			System.out.println("The column count has exceeded the column count");
			return false;
		}
	}
	
	public int executeTheUpdatingQuery(String query) throws SQLException {
		
		Statement state = connect.createStatement();
		int result = state.executeUpdate(query);
		return result;
	
	}
	
	public void closeTheConnection() throws SQLException {
		connect.close();
	}
	
}
