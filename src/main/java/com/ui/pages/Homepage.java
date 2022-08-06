package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utils.ElementUtils;

public class Homepage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	public Homepage (WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}
	
	//locators
	private By HOMEPAGEUNAME = By.xpath("//table//tr[@class='heading3']");
	private By EDITCUSTOMER = By.xpath("//a[text()='Edit Customer']");

	public boolean getHomePageDashboardUserName(String value) {
		return elementUtils.getElement(HOMEPAGEUNAME).getText().contains(value);
	}
	
	public EditUserPage navigateToEditUserPage() {
		elementUtils.clickElement(EDITCUSTOMER);
		return new EditUserPage(driver);
	}
}
