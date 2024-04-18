package datadrivenTesting.ty.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDatasIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Alpha_Shopee_Test_Cases.xlsx");
		Workbook work = WorkbookFactory.create(fis);
		
		Sheet sheetName = work.createSheet("Test Sheet");
		sheetName.createRow(0).createCell(0).setCellValue("Added successfully");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Alpha_Shopee_Test_Cases.xlsx");
		work.write(fos);
		work.close();
		
	}
}
