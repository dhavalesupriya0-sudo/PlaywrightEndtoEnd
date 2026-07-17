package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest{

	@Test(priority = 1)
	public void loginPageNavigationTest() {
		loginPage=homePage.navigateToLoginpage();
		String actualLoginPageTitle=loginPage.getLoginPageTitle();
		System.out.println("Page Actual title: "+actualLoginPageTitle);
		Assert.assertEquals(actualLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void forgotPwdLinkExitTest() {
		Assert.assertTrue(loginPage.isForgotPwdlinkExist());
	}
	
	@Test(priority = 3)
	public void appLoginTest() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username".trim()), prop.getProperty("password").trim()));
	}
}
