package com.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyService {
	
	public Properties properties;
	private static String CONFIG_PATH_UI = "/src/main/java/com/ui/config/config.ui.properties";
	private static String CONFIG_PATH_API = "/src/main/java/com/api/config/config.api.properties";
	
	public Properties init_ui_properties() {
		properties = new Properties();
		String currentDir = System.getProperty("user.dir") + CONFIG_PATH_UI;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(currentDir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found!");
		}

		return properties;
	}

	public Properties init_api_properties() {
		properties = new Properties();
		String currentDir = System.getProperty("user.dir") + CONFIG_PATH_API;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(currentDir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File not found!");
		}

		return properties;
	}

}
