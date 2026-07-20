package com.qa.opencart.pages;

import static org.testng.Assert.assertEquals;

import com.microsoft.playwright.Page;

public class RegisterPage {

	private Page page;
	
	//1. String Locators - Object Repository
		private String firstNameText="//input[@id='input-firstname']";
		private String lastNameText="//input[@id='input-lastname']";
		private String emailText="//input[@id='input-email']";
		private String telephoneText="//input[@id='input-telephone']";
		private String passwordText="//input[@id='input-password']";
		private String confirmPasswordText="//input[@id='input-confirm']";
		private String yesRadiobtn="//label[normalize-space()=\"Yes\"]";
		private String agreePrivacyPolicy="//input[@name='agree']";
		private String continuebtn="//input[@value='Continue']";
		private String acceptcongMessage="//a[normalize-space()='Continue']";
		private String MyAccountText="//h2[normalize-space()=\"My Account\"]";
		private String warningMessage="div.alert.alert-danger";
		
	//2. Registerpage constructor
		public RegisterPage(Page page) {
				this.page=page;
		}
				
	//3. page actions/methods
		public String getRegisterPageTitle() {
				return page.title();
		}
	
		public void doRegister(String appFirstName, String appLastName, String appEmail, String apptelephone, String appPassword, String appConfirmPassword) {
			page.fill(firstNameText, appFirstName);
			page.fill(lastNameText, appLastName);
			page.fill(emailText, appEmail);
			page.fill(telephoneText, apptelephone);
			page.fill(passwordText, appPassword);
			page.fill(confirmPasswordText, appConfirmPassword);
			if (page.isChecked(yesRadiobtn)) {
				System.out.println("The user has already opted in.");
			}else {
				page.check(yesRadiobtn);
			}
				
			page.check(agreePrivacyPolicy);
			page.click(continuebtn);
			
			
		}
		public String getEmailAlreadyExistsWarning() {
			return page.locator(warningMessage).textContent().trim();
		}
		
//		public boolean getConfirmationText() {
//			if(page.isVisible(congMessage)) {
//				System.out.println("Congratulation Text is: "+congMessage);
//				page.click(acceptcongMessage);
//			}return false;
//		}
/*		
		public boolean getMyAccountTitle() {
			String MyAcctit = page.title();
			System.out.println("Account registered and Title: "+MyAcctit);
			page.click(acceptcongMessage);
			if (page.isVisible(MyAccountText)) {
				System.out.println("user is successfully entered in Account...");
				return true;
			}
			return false;
	}
*/
}
