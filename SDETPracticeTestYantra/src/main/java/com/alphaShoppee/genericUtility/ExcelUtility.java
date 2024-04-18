package com.alphaShoppee.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 * This method returns the string value for the given sheet name, row index and the cell index
	 * @author karthic
	 * @param sheetName
	 * @param rowIndex
	 * @param cellIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getStringDataFromExcel(String sheetName, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(ProjectConstant.excelFileUrl);
		Workbook work = WorkbookFactory.create(fis);
		Sheet sheet = work.getSheet(sheetName);
		Row rowNum = sheet.getRow(rowIndex);
		Cell cellNum = rowNum.getCell(cellIndex);
		String stringData = "";
		try {
		stringData = cellNum.getStringCellValue();
		}
		catch(IllegalStateException ise) {
			 stringData = ""+(long)cellNum.getNumericCellValue(); 
		}
		work.close();
		return stringData;
	}
	
	/**
	 * this method writes the given value into the corresponding cell index and row index
	 * @param data
	 * @param newSheet
	 * @param rowIndex
	 * @param cellIndex
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataToExcel(String data, boolean newSheet, int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(ProjectConstant.excelFileUrl);
		Workbook work = WorkbookFactory.create(fis);
		Sheet sheetName;
		if(newSheet) {
			sheetName = work.createSheet("Data_Sheet");
		}
		else {
			sheetName = work.getSheet("Data_Sheet");
		}
		sheetName.createRow(rowIndex).createCell(cellIndex).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(ProjectConstant.excelFileUrl);
		work.write(fos);
		
	}


	public HashMap<String , String> getMultipleValuesFromExcel(String sheetNames, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(ProjectConstant.excelFileUrl);
		Workbook work = WorkbookFactory.create(fis);
		Sheet sheetName = work.getSheet(sheetNames);
		int lastRow = sheetName.getLastRowNum();
		HashMap<String, String> hMap = new HashMap<String, String>();
		
		for(int i=0; i<lastRow; i++) {
			String key = sheetName.getRow(i).getCell(cellIndex).getStringCellValue();
			String value = sheetName.getRow(i).getCell(i+1).getStringCellValue();
			hMap.put(key, value);
		}
		
		return hMap;
	}
}

