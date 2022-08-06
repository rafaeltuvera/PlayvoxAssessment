package com.ui.driverfactory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {

	WebDriver driver;
	
	
	public WebDriver initialize_driver(Properties properties) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(OptionsManager.getChromeOptions());
		driver.manage().window().maximize();
		driver.get(properties.getProperty("URL"));
		return driver;
	}
}
