package com.qa.opencart.tests;

import java.awt.print.Pageable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class RegisterPageTest extends BaseTest{
	
	@Test(priority = 1)
	public void loginPageNavigationTest() {
		registerPage=homePage.navigateToRegisterpage();
		String actualRegisterPageTitle=registerPage.getRegisterPageTitle();
		System.out.println("Page Actual title: "+actualRegisterPageTitle);
		Assert.assertEquals(actualRegisterPageTitle, AppConstants.REGISTER_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void appRegisterTest() {
		registerPage.doRegister("Priya", "T", "dhavalesupriya0@gmail.com", "1234567890", "admin@123", "admin@123");
//		String actualWarning=registerPage.getEmailAlreadyExistsWarning();
//		System.out.println("Actual Warning = ["+ actualWarning+ "]");
//		Assert.assertEquals(actualWarning.contains(" Warning: E-Mail Address is already registered!"), "Warning message is incorrect.");
		Assert.assertTrue(registerPage.getEmailAlreadyExistsWarning());
	}
/*	
	@Test(priority = 3)
	public void MyAccountTest() {
		registerPage.getMyAccountTitle();
	}
*/
}
