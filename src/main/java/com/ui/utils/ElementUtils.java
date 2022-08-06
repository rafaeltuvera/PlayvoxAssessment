package com.ui.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	
	WebDriver driver;
	WebDriverWait wait;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 10);
	}
	
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		waitForElementPresent(locator);
		try {
			element = driver.findElement(locator);
		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement elementIsDisplayed(By locator) {
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	public void clickElement(By locator) {
		waitForElementPresent(locator);
		getElement(locator).click();
	}
	
	public void sendKeys(By locator, String value) {
		waitForElementPresent(locator);
		getElement(locator).sendKeys(value);
	}
	
	public void clear (By locator) {
		waitForElementPresent(locator);
		getElement(locator).clear();
	}

}
