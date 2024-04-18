package selenium.Assignments;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alphaShoppee.adminModule.DataProviderClass;

public class TestSubClass {

	@Test(dataProviderClass = TestClass.class , dataProvider = "datasGiven")
	public void testDatas(Object firstColumn, Object secondColumn) {
		System.out.println("First Column--> "+firstColumn+"Second Column--> "+secondColumn);
	}
	
	@Test(dataProviderClass = DataProviderClass.class , dataProvider = "provideData")
	public void adminLoginDataProvider(String obj1, String obj2){
//		adminLogin(obj1, obj2);
		System.out.println(obj1);
		System.out.println(obj2);
	}

	@DataProvider(name = "provideData")
//	@Test
	public Object[][] provideData() throws EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Alpha_Shopee_Test_Cases.xlsx");
		Workbook work = WorkbookFactory.create(fis);
		Sheet sheetName = work.getSheet("Manage_Product_Test_Data");
		int rowCouunt = sheetName.getLastRowNum();	
		int cellCount = sheetName.getRow(0).getLastCellNum();
		
		System.out.println(rowCouunt+" "+cellCount);
		
		Object[][] obj = new Object[rowCouunt+1][cellCount];
		for (int i=0; i<rowCouunt; i++) {
			for (int j=0; j<cellCount; j++)
			{
				obj[i][j] = sheetName.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		}
		
	
	
	@Test(dataProvider = "provideData")
	public void printData(String s1, String s2) {
		System.out.println(s1+" ====> "+s2);
	}
	
	
}
