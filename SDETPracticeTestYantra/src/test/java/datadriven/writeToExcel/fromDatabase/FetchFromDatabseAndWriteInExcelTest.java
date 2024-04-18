package datadriven.writeToExcel.fromDatabase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.jdbc.Driver;

public class FetchFromDatabseAndWriteInExcelTest {

	public static void main(String[] args) throws SQLException, EncryptedDocumentException, IOException {
		 
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection connect = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		
		Statement state = connect.createStatement();
		
		ResultSet result = state.executeQuery("select * from project;");
		
		ArrayList<String> intermediate = new ArrayList<String>();
		ArrayList<Integer> indSize = new ArrayList<Integer>();
		
		ResultSetMetaData rsmd = result.getMetaData();
		int colCount = rsmd.getColumnCount();
		
		
		for(int i=0; i<colCount; i++) {
			int count = 0;
			result = state.executeQuery("select * from project;");
			while(result.next()) {
				intermediate.add(result.getString(i+1));
				count++;
			}
			indSize.add(count);
		}
		
		int largeNum = 0;
		
		for(int num:indSize) {
			if(num>largeNum) {
				largeNum = num;
			}
		}
									
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Alpha_Shopee_Test_Cases.xlsx");
		Workbook work = WorkbookFactory.create(fis);
		Sheet sheetName = work.createSheet("Project_sheet");
		int tempCol = 0;
		for(int i=1;i<=largeNum;i++) {
			sheetName.createRow(i);
			tempCol = i-1;
			for(int j=0;j<colCount;j++) {
				sheetName.getRow(i).createCell(j).setCellValue(intermediate.get(tempCol));
				tempCol+=indSize.get(j);
			}
		}
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Alpha_Shopee_Test_Cases.xlsx");
		work.write(fos);
		work.close();
	}
	
}
