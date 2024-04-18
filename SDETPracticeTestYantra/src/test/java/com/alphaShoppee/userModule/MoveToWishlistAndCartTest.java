package com.alphaShoppee.userModule;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.alphaShoppee.elementRepository.AdminLoginPage;
import com.alphaShoppee.elementRepository.UserCartPage;
import com.alphaShoppee.elementRepository.UserHomePage;
import com.alphaShoppee.elementRepository.UserLoginPage;
import com.alphaShoppee.elementRepository.UserProductPage;
import com.alphaShoppee.elementRepository.UserWishlistPage;
import com.alphaShoppee.genericUtility.BaseClass;
import com.alphaShoppee.genericUtility.ProjectConstant;

public class MoveToWishlistAndCartTest extends BaseClass{

	@Test
	public void moveToWishlistAndCartTest() throws IOException {
		
		
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
		
		
		productSpec.getAddtocartButton().click();
		
		UserCartPage cartPage = new UserCartPage(driver);
		cartPage.getBasketIcon().click();
		cartPage.getMyCartButton().click();
		
		UserWishlistPage wishlistPage = new UserWishlistPage(driver);
		
		if(wishlistPage.checkProduct(eUtil.getStringDataFromExcel(sheetName, 3, 1))) {
			System.out.println("The product has been moved from wishlist to cart");
		}
		else {
			System.out.println("The product is not added to the wishlist and to cart");
		}
		
		
		driver.get(ProjectConstant.adminUrl);
		AdminLoginPage adminLogin = new AdminLoginPage(driver);
		adminLogin.adminLogin(eUtil.getStringDataFromExcel("Manage_Product_Test_Data", 1, 1), eUtil.getStringDataFromExcel("Manage_Product_Test_Data", 2, 1));
		
	}
	
	
}
