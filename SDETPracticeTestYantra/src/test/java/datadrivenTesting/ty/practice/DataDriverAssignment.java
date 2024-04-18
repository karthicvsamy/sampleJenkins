package datadrivenTesting.ty.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDriverAssignment {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Alpha_Shopee_Test_Cases.xlsx");
		Workbook work = WorkbookFactory.create(fis);
		
		Sheet sheetName = work.getSheet("System Test Cases");
		
		for(int i=0;i<sheetName.getLastRowNum();i++) {
			if(sheetName.getRow(i).getCell(1).getStringCellValue().equals("View the pending orders")) {
				for(int j=0;j<sheetName.getRow(i).getLastCellNum();j++) {
					System.out.println(sheetName.getRow(i).getCell(j).getStringCellValue());
				}
			}
		}
		
		work.close();
		
	}
}
