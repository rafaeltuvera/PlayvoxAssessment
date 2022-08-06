package com.ui.test;

import com.ui.pages.EditUserPage;
import com.ui.pages.Homepage;
import com.ui.utils.ExcelReader;
import com.ui.utils.EditUserMessages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ui.pages.LoginPage;

public class EditUserTest extends BaseTestUI {

	private LoginPage loginPage;
	private Homepage homePage;
	private EditUserPage editUserPage;
	
	@BeforeMethod()
	public void editUserTest_SetUP() {
		loginPage = new LoginPage(driver);
		homePage = loginPage.login(UIproperties.getProperty("USERNAME"), UIproperties.getProperty("PASSWORD")); //login
		Assert.assertTrue(homePage.getHomePageDashboardUserName(UIproperties.getProperty("USERNAME")), "Incorrect User displayed!");//verify user login success
		editUserPage = homePage.navigateToEditUserPage();
		driver.navigate().to(UIproperties.getProperty("URLEditCustomer"));
		editUserPage.fillCustomerID(UIproperties.getProperty("CUSTOMER_ID")); // enter user id
		Assert.assertEquals(editUserPage.getEditUserPageHeading(), "Edit Customer");//verify user is navigated to edit user form
	}

	@DataProvider
	public Object[][] getTestdata(){
		return ExcelReader.getdata("UserDetails");
	}
	
	@Test
	public void Verify_Invalid_Input_Messages() {
		Assert.assertTrue(!editUserPage.isTextboxDisabled());
		editUserPage.fillPIN("12345");//validate length of input is invalid
		Assert.assertTrue(editUserPage.validatePINInputLength());//validate message is displayed
		Assert.assertEquals(editUserPage.getInvalidMessagePIN(),EditUserMessages.INVALID_MESSAGE_PIN_LEN_TXT);//validate error message is correct

		//input invalid values
		editUserPage.fillCity("CITY3000");
		editUserPage.fillState("STATE3001");
		editUserPage.fillPIN("342PIN");
		editUserPage.fillMobileNo("0933NUM");

		//validate error messages displayed
		Assert.assertTrue(editUserPage.isCityInvalidInput());
		Assert.assertTrue(editUserPage.isStateInvalidInput());
		Assert.assertTrue(editUserPage.isPINInvalidInput());
		Assert.assertTrue(editUserPage.isMobileInvalidInput());

		//validate error messages values
		Assert.assertEquals(editUserPage.getInvalidMessageCity(), EditUserMessages.INVALID_MESSAGE_CITY_TXT);
		Assert.assertEquals(editUserPage.getInvalidMessageState(), EditUserMessages.INVALID_MESSAGE_STATE_TXT);
		Assert.assertEquals(editUserPage.getInvalidMessagePIN(), EditUserMessages.INVALID_MESSAGE_PIN_TXT);
		Assert.assertEquals(editUserPage.getInvalidMessageMobile(), EditUserMessages.INVALID_MESSAGE_MOBILE_TXT);

		editUserPage.clickSubmitForm();//save record
		//verify error message value and close alert box
		Assert.assertEquals(editUserPage.gettAlertText(), EditUserMessages.INVALID_MESSAGE_INVALID_RECORD);
		editUserPage.acceptAlert();
	}


	@Test(dataProvider = "getTestdata")
	public void verify_user_details_updated(String CustID, String CustName, String Gender, String DOB, String Address, String City, String State, String PIN, String Mobile, String Email){
		editUserPage.updateUserDetails(Address, City, State, PIN, Mobile); //update user
		editUserPage.acceptAlert();
		editUserPage.fillCustomerID(CustID); // enter user id

		//get updated user details and validate values
		Assert.assertEquals(editUserPage.getCustomerName(), CustName);
		Assert.assertEquals(editUserPage.getGender(), Gender);
		Assert.assertEquals(editUserPage.getDOB(), DOB);
		Assert.assertEquals(editUserPage.getAddress(), Address);
		Assert.assertEquals(editUserPage.getCity(), City);
		Assert.assertEquals(editUserPage.getState(), State);
		Assert.assertEquals(editUserPage.getPin(), PIN);
		Assert.assertEquals(editUserPage.getMobile(), Mobile);
	}
	
}
