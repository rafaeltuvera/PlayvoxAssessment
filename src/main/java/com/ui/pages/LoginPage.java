package com.ui.pages;

import com.api.utils.ApiUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utils.ElementUtils;


public class LoginPage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	
	//locators
	private By USER_NAME = By.name("uid");
	private By PASSWORD = By.name("password");
	private By BTN_LOGIN = By.name("btnLogin");
	
	
	public Homepage login(String username, String password) {
		elementUtils.sendKeys(USER_NAME, username);
		elementUtils.sendKeys(PASSWORD, ApiUtils.base64Decode(password));
		elementUtils.clickElement(BTN_LOGIN);
		
		return new Homepage(driver);
	}
	
}
