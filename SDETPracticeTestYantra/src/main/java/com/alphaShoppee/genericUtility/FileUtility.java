package com.alphaShoppee.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String getValueFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(ProjectConstant.propertyFileUrl);
		Properties propObj = new Properties();
		propObj.load(fis);
		return propObj.getProperty(key);
		
	}
	
	public void writeKeyAndValue(String key, String value) throws IOException {
		
		FileInputStream fis = new FileInputStream(ProjectConstant.propertyFileUrl);
		Properties propObj = new Properties();
		propObj.load(fis);
		propObj.setProperty(key, value);
		FileOutputStream fos = new FileOutputStream(ProjectConstant.propertyFileUrl);
		propObj.store(fos, "Key and value added");
		
	}
}
