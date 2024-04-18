package com.alphaShoppee.userModule;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.alphaShoppee.elementRepository.AdminLoginPage;
import com.alphaShoppee.elementRepository.UserHomePage;
import com.alphaShoppee.elementRepository.UserLoginPage;
import com.alphaShoppee.elementRepository.UserProductPage;
import com.alphaShoppee.elementRepository.UserWishlistPage;
import com.alphaShoppee.genericUtility.BaseClass;
import com.alphaShoppee.genericUtility.ProjectConstant;

public class MoveToWishlistAndRemoveTest extends BaseClass{

	@Test(retryAnalyzer = com.alphaShoppee.genericUtility.RetryAnalyzerImplementationClass.class)
	public void moveToWishlistAndRemoveTest() throws IOException {
		
		
		String sheetName = "Purchase_Product_Test_Datas";
		
		
		driver.get(eUtil.getStringDataFromExcel(sheetName, 0, 1));
		
		UserHomePage homepage = new UserHomePage(driver);
		UserLoginPage userLogin = new UserLoginPage(driver);	
				
		homepage.getLoginTab().click();
		userLogin.loginToUser(eUtil.getStringDataFromExcel(sheetName, 1, 1), eUtil.getStringDataFromExcel(sheetName, 2, 1));
		
		if(homepage.getWelcomeText().isDisplayed()) {
			System.out.println("Logged in successfully");
		}
		else {
			System.out.println("Login is not successful");
		}		
		
		
		homepage.getSearchBox().sendKeys(eUtil.getStringDataFromExcel(sheetName, 3, 1)+Keys.ENTER);
		homepage.clickRequiredProduct(eUtil.getStringDataFromExcel(sheetName, 3, 1));
		
		UserProductPage productSpec = new UserProductPage(driver);
		productSpec.getWishlistButton().click();
		
		
		
		if(productSpec.wishlistConfirmation(eUtil.getStringDataFromExcel(sheetName, 3, 1))) {
			System.out.println("The product has been added to the wishlist");
		}
		else {
			System.out.println("The product has not been added to the wishlist");
		}
		
		UserWishlistPage wishlistPage = new UserWishlistPage(driver);
		
		wishlistPage.getRemoveButton().click();
		wUtil.acceptAlert();
		
		try {
			wishlistPage.checkProductIsThere(eUtil.getStringDataFromExcel(sheetName, 3, 1));
		}
		catch (NoSuchElementException nse) {
			System.out.println("The product has been removed from wishlist successfully");
		}
		
		driver.get(ProjectConstant.adminUrl);
		AdminLoginPage adminLogin = new AdminLoginPage(driver);
		adminLogin.adminLogin(eUtil.getStringDataFromExcel("Manage_Product_Test_Data", 1, 1), eUtil.getStringDataFromExcel("Manage_Product_Test_Data", 2, 1));

	}
}
