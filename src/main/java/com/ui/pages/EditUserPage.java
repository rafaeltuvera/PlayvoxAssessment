package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utils.ElementUtils;

public class EditUserPage {

	WebDriver driver;
	ElementUtils elementUtils;

	public EditUserPage(WebDriver driver) {
		this.driver = driver;
		elementUtils = new ElementUtils(this.driver);
	}

	// locators
	private final By HEADING = By.xpath("//p[text()='Edit Customer']");
	private final By BTN_SUBMIT = By.name("AccSubmit");
	private final By BTN_SUBMIT_FORM = By.xpath("//input[@name='sub']");
	private final By TXT_CUSTOMER_ID = By.xpath("//input[@name='cusid']");
	private final By TXT_NAME = By.xpath("//input[@name='name']");
	private final By TXT_GENDER = By.xpath("//input[@name='gender']");
	private final By TXT_DOB = By.xpath("//input[@name='dob']");
	private final By TXT_ADDR = By.xpath("//textarea[@name='addr']");
	private final By TXT_CITY = By.xpath("//input[@name='city']");
	private final By TXT_STATE = By.xpath("//input[@name='state']");
	private final By TXT_PIN = By.xpath("//input[@name='pinno']");
	private final By TXT_MOBILE = By.xpath("//input[@name='telephoneno']");

	private final By MSG_CITY_INVALID_INPUT = By.id("message4");
	private final By MSG_STATE__INVALID_INPUT = By.id("message5");
	private final By MSG_PIN_INVALID_INPUT = By.id("message6");
	private final By MSG_MOBILE_INVALID_INPUT = By.id("message7");


	public String getEditUserPageHeading() {
		return elementUtils.getElement(HEADING).getText();
	}

	public void fillCustomerID(String value) {
		elementUtils.sendKeys(TXT_CUSTOMER_ID, value);
		clickSubmit();
	}

	public void clickSubmit() {
		elementUtils.clickElement(BTN_SUBMIT);
	}

	public void clickSubmitForm() {
		elementUtils.clickElement(BTN_SUBMIT_FORM);
	}

	public boolean isTextboxDisabled() {
		boolean isDisabled = true;
		isDisabled = elementUtils.getElement(TXT_NAME).isEnabled();
		isDisabled = elementUtils.getElement(TXT_GENDER).isEnabled();
		isDisabled = elementUtils.getElement(TXT_DOB).isEnabled();
		return isDisabled;
	}

	public void fillAddress(String value) {
		elementUtils.clear(TXT_ADDR);
		elementUtils.sendKeys(TXT_ADDR, value);
	}
	
	public void fillCity(String value) {
		elementUtils.clear(TXT_CITY);
		elementUtils.sendKeys(TXT_CITY, value);
	}
	
	public void fillState(String value) {
		elementUtils.clear(TXT_STATE);
		elementUtils.sendKeys(TXT_STATE, value);
	}
	
	public void fillPIN(String value) {
		elementUtils.clear(TXT_PIN);
		elementUtils.sendKeys(TXT_PIN, value);
	}
	
	public void fillMobileNo(String value) {
		elementUtils.clear(TXT_MOBILE);
		elementUtils.sendKeys(TXT_MOBILE, value);
	}

	public void updateUserDetails(String Address, String City, String State, String PIN, String Mobile){
		fillAddress(Address);
		fillCity(City);
		fillState(State);
		fillPIN(PIN);
		fillMobileNo(Mobile);
		clickSubmitForm();
	}

	//getters
	public String getCustomerName() { return elementUtils.getElement(TXT_NAME).getAttribute("value"); }
	public String getGender() { return elementUtils.getElement(TXT_GENDER).getAttribute("value"); }
	public String getDOB() { return elementUtils.getElement(TXT_DOB).getAttribute("value"); }
	public String getAddress() { return elementUtils.getElement(TXT_ADDR).getAttribute("value"); }
	public String getCity() { return elementUtils.getElement(TXT_CITY).getAttribute("value"); }
	public String getState() { return elementUtils.getElement(TXT_STATE).getAttribute("value"); }
	public String getPin() { return elementUtils.getElement(TXT_PIN).getAttribute("value"); }
	public String getMobile() { return elementUtils.getElement(TXT_MOBILE).getAttribute("value");}

	//verify error messages are displayed
	public boolean isCityInvalidInput() {return elementUtils.getElement(MSG_CITY_INVALID_INPUT).isDisplayed();}
	public boolean isStateInvalidInput() { return elementUtils.getElement(MSG_STATE__INVALID_INPUT).isDisplayed();}
	public boolean isPINInvalidInput() {
		return elementUtils.getElement(MSG_PIN_INVALID_INPUT).isDisplayed();
	}
	public boolean isMobileInvalidInput() {
		return elementUtils.getElement(MSG_MOBILE_INVALID_INPUT).isDisplayed();
	}

	// get messages value for invalid input
	public String getInvalidMessageCity() {return elementUtils.getElement(MSG_CITY_INVALID_INPUT).getText();}
	public String getInvalidMessageState() {
		return elementUtils.getElement(MSG_STATE__INVALID_INPUT).getText();
	}
	public String getInvalidMessagePIN() {return elementUtils.getElement(MSG_PIN_INVALID_INPUT).getText();}
	public String getInvalidMessageMobile() {
		return elementUtils.getElement(MSG_MOBILE_INVALID_INPUT).getText();
	}

	// alert handling
	public void acceptAlert(){ driver.switchTo().alert().accept();}
	public String gettAlertText(){return driver.switchTo().alert().getText();}


	public boolean validatePINInputLength(){
		String value = elementUtils.getElement(TXT_PIN).getText();
		boolean isValid = false;

		if (!(value.length() > 6)) {
			isValid = isPINInvalidInput();
		}else {
			isValid = true;
		}

		return isValid;
	}

}
