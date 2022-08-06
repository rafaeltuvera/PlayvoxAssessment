package com.ui.test;

import java.util.Properties;

import com.api.utils.ApiUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import com.ui.driverfactory.Driverfactory;
import com.services.PropertyService;
import org.testng.annotations.BeforeMethod;

public class BaseTestUI {
	
	protected Driverfactory driverFactoy;
	protected PropertyService propertyService;
	protected Properties UIproperties;
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup_ui() {
		driverFactoy = new Driverfactory(); 
		propertyService = new PropertyService();
		UIproperties = propertyService.init_ui_properties();
		driver = driverFactoy.initialize_driver(UIproperties);
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	

}
