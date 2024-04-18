package com.alphaShoppee.adminModule;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

import com.alphaShoppee.genericUtility.ExcelUtility;

public class DataProviderClass {

	@DataProvider(name = "provideData")
	
	public Object[][] dataProviderMethod() throws EncryptedDocumentException, IOException {
		
		String sheetName = "Manage_Product_Test_Data";
		Object[][] obj = new Object[1][2];
		
		ExcelUtility eUtil = new ExcelUtility();
		obj[0][0] = eUtil.getStringDataFromExcel(sheetName, 1, 1);
		obj[0][1] = eUtil.getStringDataFromExcel(sheetName, 2, 1);
		return obj;
		
		
	}
	
}
