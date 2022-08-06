package com.api.test;

import io.restassured.response.Response;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.utils.Constants;

public class APItest extends BaseTestApi{

	private String Token;
	private String userid;
	private String name;
	private String email;
	private String password;

	@BeforeMethod
	public void getToken() throws JSONException {
		String payload = constructPayload.constructLoginPayload(Constants.LOGIN_PAYLOAD_PATH,
				APIProperties.getProperty("EMAIL"), APIProperties.getProperty("PASSWORD"));
		Token = urequests.getToken(payload, APIProperties.getProperty("GETToken"));
	}

	@Test(priority = 0)
	public void validate_response_401_user_not_authorized() throws JSONException {
		String payload = constructPayload.constructAddUserPayload(Constants.ADDUSER_PAYLOAD_PATH, "", "", "");
		urequests.POSTnewUserNoAuth(payload,APIProperties.getProperty("POSTUser"));
	}

	@Test(priority = 1)
	public void validate_response_201_add_new_user() throws JSONException {
		apiuser.setName("test-user" + apiUtils.getDatetimeInMillis());
		apiuser.setEmail(apiuser.getName()+"@hotmail.com");
		apiuser.setPassword("123444");
		name = apiuser.getName();
		email = apiuser.getEmail();
		password = apiuser.getPassword();

		String payload = constructPayload.constructAddUserPayload(Constants.ADDUSER_PAYLOAD_PATH, name, email, password);
		userid = urequests.POSTnewUser(payload,APIProperties.getProperty("POSTUser"), Token);
	}

	@Test(priority = 2)
	public void validate_response_400_add_existing_user() throws JSONException {
		String payload = constructPayload.constructAddUserPayload(Constants.ADDUSER_PAYLOAD_PATH, name, email, password);
		urequests.POSTExistingUser(payload,APIProperties.getProperty("POSTUser"), Token);
	}

	@Test(priority = 3)
	public void validate_response_500_invalid_payload() throws JSONException {
		String payload = apiUtils.getFile(Constants.INVALID_PAYLOAD_PATH);
		urequests.POSTInvalidPayload(payload,APIProperties.getProperty("POSTUser"), Token);
	}

	@Test(priority = 4)
	public void validate_get_user(){
		Response responseBody = urequests.getUser(APIProperties.getProperty("GETUser"),userid, Token);

		String response_id = responseBody.jsonPath().getString("id");
		String response_name = responseBody.jsonPath().getString("name");
		String response_email = responseBody.jsonPath().getString("email");

		Assert.assertEquals(response_id, userid);
		Assert.assertEquals(response_name, name);
		Assert.assertEquals(response_email, email);

		System.out.println(responseBody.toString());
	}

}
