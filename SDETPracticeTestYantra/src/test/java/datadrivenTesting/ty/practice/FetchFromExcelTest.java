package datadrivenTesting.ty.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Alpha_Shopee_Test_Cases.xlsx");
		Workbook work = WorkbookFactory.create(fis);
		
		Sheet sheetName = work.getSheet("System Test Cases");
		
		int lastCellCount = sheetName.getLastRowNum();
		
		for(int i=0;i<=lastCellCount;i++) {
			String data = sheetName.getRow(i).getCell(1).getStringCellValue();
			if(!data.isEmpty()) {
				System.out.println(data);
			}
		}
		
		
	}
}
