package com.alphaShoppee.adminModule;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.alphaShoppee.elementRepository.AdminCategoryPage;
import com.alphaShoppee.elementRepository.AdminInsertProductPage;
import com.alphaShoppee.elementRepository.AdminManageProductsPage;
import com.alphaShoppee.elementRepository.AdminSubcategoryPage;
import com.alphaShoppee.genericUtility.BaseClass;


//@Listeners(com.alphaShoppee.genericUtility.ListenerImplementationClass.class)
public class ManageTheInsertedProductTest extends BaseClass{


	@Test(retryAnalyzer = com.alphaShoppee.genericUtility.RetryAnalyzerImplementationClass.class)
	public void manageTheInsertedProductTest() throws IOException {
		
		String sheetName = "Manage_Product_Test_Data";

		AdminCategoryPage adminCategory = new AdminCategoryPage(driver);
		adminCategory.getCreateCategoryTab().click();
		adminCategory.createACategory(eUtil.getStringDataFromExcel(sheetName, 6, 1),eUtil.getStringDataFromExcel(sheetName, 7, 1));

		AdminSubcategoryPage adminSubcategory = new AdminSubcategoryPage(driver);
		adminCategory.getSubcategoryTab().click();
		adminSubcategory.createASubcategory(wUtil, eUtil.getStringDataFromExcel(sheetName, 6, 1),eUtil.getStringDataFromExcel(sheetName, 8, 1));

		AdminInsertProductPage insertProduct = new AdminInsertProductPage(driver);
		adminCategory.getInsertProductTab().click();

		insertProduct.selectCategory(eUtil.getStringDataFromExcel(sheetName, 6, 1));
		insertProduct.selectSubcategory(eUtil.getStringDataFromExcel(sheetName, 8, 1));

		insertProduct.insertFirstSet(eUtil.getStringDataFromExcel(sheetName, 9, 1),
				eUtil.getStringDataFromExcel(sheetName, 10, 1), eUtil.getStringDataFromExcel(sheetName, 11, 1),
				eUtil.getStringDataFromExcel(sheetName, 12, 1), eUtil.getStringDataFromExcel(sheetName, 13, 1),
				eUtil.getStringDataFromExcel(sheetName, 14, 1));
		insertProduct.selectAvailability(eUtil.getStringDataFromExcel(sheetName, 15, 1));
		insertProduct.imagePaths(eUtil.getStringDataFromExcel(sheetName, 16, 1),eUtil.getStringDataFromExcel(sheetName, 17, 1), eUtil.getStringDataFromExcel(sheetName, 18, 1));
		insertProduct.getSubmitButton().click();

		
		if (insertProduct.getWelldoneText().isDisplayed()) {
			System.out.println("The product has been successfully created");
		} else {
			System.out.println("The product creation failed");
		}

		adminCategory.getManageProductsTab().click();
		AdminManageProductsPage manageProducts = new AdminManageProductsPage(driver);
		manageProducts.getSearchTextfield().sendKeys(eUtil.getStringDataFromExcel(sheetName, 9, 1) + Keys.ENTER);
		
		if (manageProducts.getTableSecondColumn().getText().contains(eUtil.getStringDataFromExcel(sheetName, 9, 1))) {
			System.out.println("The product is displayed in the manage product list");
		} else {
			System.out.println("The created product is not found");
		}

		manageProducts.getFirstEditIcon().click();
		manageProducts.changeAvailability(eUtil.getStringDataFromExcel(sheetName, 19, 1));
		manageProducts.getSubmitButton().click();
		if (manageProducts.getWelldoneText().isDisplayed()) {
			System.out.println("The product has been updated successfully");
		} else {
			System.out.println("The product updation failed");
		}

		
	}
}
