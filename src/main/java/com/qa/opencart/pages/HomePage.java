package com.qa.opencart.pages;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;
	
	//1. String Locator - Object Repository
	private String search="input[name='search']";
	private String searchIcon="div#search button";
	private String searchPageHeader="div#content h1";
	private String loginlink="//a[text()=('Login')]";
	private String myAccountLink="//a[@title=\"My Account\"]";
	private String registerLink="//a[normalize-space()=\"Register\"]";
	
		//2. Homepage constructor
	public HomePage(Page page) {
		this.page=page;
	}
	
		//3. page actions/methods
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("Page Title:" +title);
		return title;
	}
	
	public String getHomePageURL() {
		String url = page.url();
		System.out.println("Page URL: "+url);
		return url;
	}
	
	public String doSearch(String productName) {
		page.fill(search,productName);
		page.click(searchIcon);
		String header = page.textContent(searchPageHeader);
		System.out.println("Search Header: "+header);
		return header;
	}
	
	public LoginPage navigateToLoginpage() {
		page.click(myAccountLink);
		page.click(loginlink);
		return new LoginPage(page);
	}
	
	public RegisterPage navigateToRegisterpage() {
		page.click(myAccountLink);
		page.click(registerLink);
		return new RegisterPage(page);
	}
}
