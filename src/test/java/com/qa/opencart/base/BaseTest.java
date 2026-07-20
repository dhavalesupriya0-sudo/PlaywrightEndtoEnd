package com.qa.opencart.base;

import java.util.Properties;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterPage;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected RegisterPage  registerPage;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		System.out.println("=========SETUP STARTED========");
		pf=new PlaywrightFactory();
		prop=pf.init_prop();
		page=pf.initBrowser(prop);
		
		System.out.println("Page = "+ page);
		homePage=new HomePage(page);
		System.out.println("HomePage = "+homePage);
	}
	
	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}
	
	
}
