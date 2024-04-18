package com.alphaShoppee.genericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.alphaShoppee.elementRepository.AdminHomePage;
import com.alphaShoppee.elementRepository.AdminLoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;
	
	public DatabaseUtility dUtil = new DatabaseUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public FileUtility fUtil = new FileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebdriverUtility wUtil;
	
	
	@BeforeSuite
	public void connectToDatabase() throws EncryptedDocumentException, SQLException, IOException {
		dUtil.openConnectionToDataBase(eUtil.getStringDataFromExcel("Database_sheet", 1, 6), eUtil.getStringDataFromExcel("Database_sheet", 2, 6), eUtil.getStringDataFromExcel("Database_sheet", 3, 6));
		Reporter.log("Database connection is successful",true);
	}
	
//	@Parameters("browser")
	@BeforeClass
	public void launchBrowser() throws IOException {
		
		
		if (fUtil.getValueFromPropertyFile("browser").equals("chrome")) {
			driver = new ChromeDriver();
		} else if (fUtil.getValueFromPropertyFile("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("The browser name is not valid");
		}
		
		sDriver = driver;
		wUtil = new WebdriverUtility(driver);
		wUtil.maximizeTheScreen();
		wUtil.implicitWait(5);
		driver.get(ProjectConstant.adminUrl);
	}
	
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException {
		AdminLoginPage adminLogin = new AdminLoginPage(driver);
		adminLogin.adminLogin(eUtil.getStringDataFromExcel("Manage_Product_Test_Data", 1, 1), eUtil.getStringDataFromExcel("Manage_Product_Test_Data", 2, 1));
		Reporter.log("Logged in successfully",true);
	}
	
	@AfterMethod
	public void logout() throws IOException {
		AdminHomePage adminHome = new AdminHomePage(driver);
		adminHome.logout();
		Reporter.log("Logged out successfully", true);
	}
	
	@AfterClass
	public void closeTheBrowser() {
		driver.quit();
		Reporter.log("The browser is closed successfully",true);
	}
	
	@AfterSuite
	public void closeTheDatabase() throws SQLException {
		dUtil.closeTheConnection();
		Reporter.log("The database is closed successfully",true);
	}
	
	
}
