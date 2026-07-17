package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;
	
	//1. String Locators - Object Repository
	private String emailid="//input[@id='input-email']";
	private String password="//input[@id='input-password']";
	private String loginbtn="//input[@value='Login']";
	private String forgotPwdLink="div[class=\"form-group\"] a";
	private String logoutLink="//a[@class='list-group-item'][normalize-space()='Logout']";
	
	//2. Loginpage constructor
		public LoginPage(Page page) {
			this.page=page;
		}
		
	//3. page actions/methods
		public String getLoginPageTitle() {
			return page.title();
		}
		
		public boolean isForgotPwdlinkExist() {
			return page.isVisible(forgotPwdLink);
		}
		
		public boolean doLogin(String appusername, String apppassword) {
			System.out.println("App Credentials: "+ appusername + ":" + apppassword);
			page.fill(emailid, appusername);
			page.fill(password, apppassword);
			page.click(loginbtn);
			if (page.isVisible(logoutLink)) {
				System.out.println("user is loged in successfully...");
				return true;
			}
			return false;
		}
		
		
}
