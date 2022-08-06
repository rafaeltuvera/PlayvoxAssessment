package com.api.test;

import java.util.Properties;

import com.api.pojo.APIUser;
import com.api.utils.ApiUtils;
import org.testng.annotations.BeforeMethod;

import com.api.requests.UserRequests;
import com.api.steps.ConstructPayload;
import com.services.PropertyService;

import io.restassured.RestAssured;

public class BaseTestApi {

	protected Properties APIProperties;
	protected PropertyService propertyService; 
	protected ConstructPayload constructPayload; 
	protected UserRequests urequests;
	protected ApiUtils apiUtils;
	protected APIUser apiuser;
	
	
	@BeforeMethod
	public void setup_api() {
		propertyService = new PropertyService();
		APIProperties = propertyService.init_api_properties();
		RestAssured.baseURI = APIProperties.getProperty("BaseURL");
		constructPayload = new ConstructPayload();
		urequests = new UserRequests();
		apiUtils = new ApiUtils();
		apiuser = new APIUser();
	}
}
